package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.CommentService;

import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDTO create(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setPostId(commentDTO.getPostId());
        comment.setAuthorId(commentDTO.getAuthorId());
        comment = commentRepository.save(comment);
        commentDTO.setId(comment.getId());
        return commentDTO;
    }

    @Override
    public List<CommentDTO> getComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment : comments) {
            commentDTOS.add(new CommentDTO(comment.getId(), comment.getContent(), comment.getAuthorId(), comment.getPostId()));
        }
        return commentDTOS;
    }

    @Override
    public CommentDTO getComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
        return new CommentDTO(comment.getId(), comment.getContent(), comment.getAuthorId(), comment.getPostId());
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
        comment.setContent(commentDTO.getContent());
        comment.setPostId(commentDTO.getPostId());
        comment.setAuthorId(commentDTO.getAuthorId());
        comment = commentRepository.save(comment);
        return new CommentDTO(comment.getId(), comment.getContent(), comment.getAuthorId(), comment.getPostId());
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }


}
