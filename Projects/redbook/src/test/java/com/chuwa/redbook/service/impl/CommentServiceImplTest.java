package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Comment comment;
    private CommentDTO commentDTO;

    @BeforeEach
    void setUp() {
        comment = new Comment();
        comment.setId(1L);
        comment.setText("Test Comment");
        comment.setPost(new Post(10L));

        commentDTO = new CommentDTO();
        commentDTO.setId(1L);
        commentDTO.setText("Test Comment");
        commentDTO.setPostId(10L);
    }

    @Test
    void testGetAllComments() {
        when(commentRepository.findAll()).thenReturn(Arrays.asList(comment));

        List<CommentDTO> result = commentService.getAllComments();

        assertEquals(1, result.size());
        assertEquals("Test Comment", result.get(0).getText());
        verify(commentRepository, times(1)).findAll();
    }

    @Test
    void testGetCommentById_Found() {
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        CommentDTO result = commentService.getCommentById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Comment", result.getText());
        verify(commentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCommentById_NotFound() {
        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L));
        verify(commentRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateComment() {
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDTO result = commentService.createComment(commentDTO);

        assertNotNull(result);
        assertEquals("Test Comment", result.getText());
        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    void testUpdateComment_Found() {
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDTO result = commentService.updateComment(1L, commentDTO);

        assertNotNull(result);
        assertEquals("Test Comment", result.getText());
        verify(commentRepository, times(1)).findById(1L);
        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    void testUpdateComment_NotFound() {
        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, commentDTO));
        verify(commentRepository, times(1)).findById(1L);
        verify(commentRepository, never()).save(any(Comment.class));
    }

    @Test
    void testDeleteComment() {
        doNothing().when(commentRepository).deleteById(1L);

        assertDoesNotThrow(() -> commentService.deleteComment(1L));

        verify(commentRepository, times(1)).deleteById(1L);
    }
}

