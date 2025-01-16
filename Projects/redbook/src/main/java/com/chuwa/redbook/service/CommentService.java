package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.payload.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getAllComments();
    CommentDTO getCommentById(Long id);
    CommentDTO createComment(CommentDTO comment);
    CommentDTO updateComment(Long id, CommentDTO commentDetails);
    void deleteComment(Long id);
}

