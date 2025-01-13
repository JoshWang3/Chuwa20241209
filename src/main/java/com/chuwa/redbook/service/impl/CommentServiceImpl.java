package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> getComments() {
        List<Comment> commentList = commentRepository.findAll();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(Comment comment : commentList){
            commentDTOList.add(convertComment2CommentDTO(comment));
        }
        return commentDTOList;
    }

    @Override
    public CommentDTO getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));
        return convertComment2CommentDTO(comment);
    }

    @Override
    public void addComment(CommentDTO commentDTO) {
        Comment comment = convertCommentDTO2Comment(commentDTO);
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(Long commentId, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));
        if(comment != null){
            comment.setAuthor(commentDTO.getAuthor());
            comment.setPost(commentDTO.getPost());
            comment.setContent(commentDTO.getContent());

            commentRepository.save(comment);
        }
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));
        if(comment != null){
            commentRepository.delete(comment);
        }

    }
    public CommentDTO convertComment2CommentDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setContent(comment.getContent());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setPost(comment.getPost());
        return commentDTO;

    }
    public Comment convertCommentDTO2Comment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setAuthor(commentDTO.getAuthor());
        comment.setPost(commentDTO.getPost());
        comment.setContent(commentDTO.getContent());
        comment.setId(commentDTO.getCommentId());
        return comment;
    }
}
