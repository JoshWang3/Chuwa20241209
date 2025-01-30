package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Post post;
    private Comment comment;
    private CommentDto commentDto;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setId(1L);

        comment = new Comment();
        comment.setId(1L);
        comment.setName("Test User");
        comment.setEmail("test@example.com");
        comment.setBody("Test comment body");
        comment.setPost(post);

        commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setName("Test User");
        commentDto.setEmail("test@example.com");
        commentDto.setBody("Test comment body");
    }

    @Test
    void createComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto result = commentService.createComment(1L, commentDto);

        assertNotNull(result);
        assertEquals(commentDto.getName(), result.getName());
        assertEquals(commentDto.getEmail(), result.getEmail());
        assertEquals(commentDto.getBody(), result.getBody());
        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    void getCommentsByPostId() {
        when(commentRepository.findByPostId(1L)).thenReturn(Arrays.asList(comment));

        List<CommentDto> result = commentService.getCommentsByPostId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(comment.getName(), result.get(0).getName());
        assertEquals(comment.getEmail(), result.get(0).getEmail());
    }

    @Test
    void getCommentById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        CommentDto result = commentService.getCommentById(1L, 1L);

        assertNotNull(result);
        assertEquals(comment.getName(), result.getName());
        assertEquals(comment.getEmail(), result.getEmail());
    }

    @Test
    void getCommentById_ThrowsException_WhenCommentNotBelongToPost() {
        Post differentPost = new Post();
        differentPost.setId(2L);
        comment.setPost(differentPost);

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        assertThrows(BlogAPIException.class, () -> 
            commentService.getCommentById(1L, 1L));
    }

    @Test
    void updateComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto result = commentService.updateComment(1L, 1L, commentDto);

        assertNotNull(result);
        assertEquals(commentDto.getName(), result.getName());
        assertEquals(commentDto.getEmail(), result.getEmail());
        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    void deleteComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        commentService.deleteComment(1L, 1L);

        verify(commentRepository, times(1)).delete(comment);
    }

    @Test
    void commentServiceMapperUtil() {
        CommentDto result = CommentServiceImpl.commentServiceMapperUtil(comment);

        assertNotNull(result);
        assertEquals(comment.getId(), result.getId());
        assertEquals(comment.getName(), result.getName());
        assertEquals(comment.getEmail(), result.getEmail());
        assertEquals(comment.getBody(), result.getBody());
    }

    @Test
    void commentServiceMapperUtil_HandlesNull() {
        CommentDto result = CommentServiceImpl.commentServiceMapperUtil(null);
        assertNull(result);
    }
}