package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getComments();

    CommentDTO getCommentById(Long commentId);

    void addComment(CommentDTO commentDTO);

    void updateComment(Long commentId, CommentDTO commentDTO);

    void deleteComment(Long commentId);
}
