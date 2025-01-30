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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CommentServiceImplTest {
    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Comment comment;
    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        post = new Post();
        post.setId(1L);

        comment = new Comment();
        comment.setId(1L);
        comment.setPost(post);
        comment.setBody("Test comment");
    }

    @Test
    void createComment() {
        CommentDto commentDto = new CommentDto();
        commentDto.setBody("Test comment");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto result = commentService.createComment(1L, commentDto);

        assertNotNull(result);
        assertEquals("Test comment", result.getBody());
    }

    @Test
    void testCreateComment_EmptyCommentBody_ShouldThrowException() {
        // Given: A valid post exists
        Post post = new Post();
        post.setId(1L);
        when(postRepository.findById(1L)).thenReturn(Optional.of(post)); // Mock valid post

        // Given: A CommentDto with an empty body
        CommentDto commentDto = new CommentDto();
        commentDto.setBody("   "); // Empty body

        // When & Then: Assert that BlogAPIException is thrown due to empty comment body
        BlogAPIException exception = assertThrows(BlogAPIException.class,
                () -> commentService.createComment(1L, commentDto));

        assertEquals("Comment body cannot be empty", exception.getMessage());
    }

    @Test
    void testCreateComment_NullCommentDto_ShouldThrowException() {
        assertThrows(BlogAPIException.class, () -> commentService.createComment(1L, null));
    }

    @Test
    void testCreateComment_PostNotFound_ShouldThrowException() {
        CommentDto commentDto = new CommentDto();
        commentDto.setBody("Valid Comment");

        when(postRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1L, commentDto));
    }

    @Test
    void getCommentsByPostId() {
        when(commentRepository.findByPostId(1L)).thenReturn(Arrays.asList(comment));

        List<CommentDto> result = commentService.getCommentsByPostId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test comment", result.get(0).getBody());
    }

    @Test
    void getCommentById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        CommentDto result = commentService.getCommentById(1L, 1L);

        assertNotNull(result);
        assertEquals("Test comment", result.getBody());
    }

    @Test
    void testGetCommentById_CommentDoesNotBelongToPost_ShouldThrowException() {
        Post anotherPost = new Post();
        anotherPost.setId(2L);
        comment.setPost(anotherPost);

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        assertThrows(BlogAPIException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void updateComment() {
        CommentDto commentDto = new CommentDto();
        commentDto.setBody("Updated comment");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto result = commentService.updateComment(1L, 1L, commentDto);

        assertNotNull(result);
        assertEquals("Updated comment", result.getBody());
    }


    @Test
    void testUpdateComment_EmptyBody_ShouldThrowException() {
        CommentDto commentDto = new CommentDto();
        commentDto.setBody("   ");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void deleteComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        commentService.deleteComment(1L, 1L);

        verify(commentRepository, times(1)).delete(comment);
    }
}