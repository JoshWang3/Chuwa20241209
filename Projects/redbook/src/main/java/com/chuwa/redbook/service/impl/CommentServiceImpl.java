package com.chuwa.redbook.service.impl;
import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll().stream().map(CommentServiceImpl::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentById(Long id) {
        return convertToDTO(commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id)));
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setText(commentDTO.getText());
        comment.setPost(new Post(commentDTO.getPostId()));
        return convertToDTO(commentRepository.save(comment));
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentDetails) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
        comment.setText(commentDetails.getText());
        comment.setPost(new Post(commentDetails.getPostId()));
        return convertToDTO(commentRepository.save(comment));
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    private static CommentDTO convertToDTO(Comment comment) {
        CommentDTO commentResponse = new CommentDTO();
        commentResponse.setId(comment.getId());
        commentResponse.setText(comment.getText());
        commentResponse.setPostId(comment.getPost().getId());
        return commentResponse;
    }
}
