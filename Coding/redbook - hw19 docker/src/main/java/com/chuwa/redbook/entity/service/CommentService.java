package com.chuwa.redbook.entity.service;

import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.payload.PageDTO;


public interface CommentService {

    CommentDTO addComment(CommentDTO comment);

    CommentDTO getComment(Long commentId);

    PageDTO<CommentDTO> getCommentList(Long postId, int startPage, int pageSize);

    void deleteComment(Long commentId);

    CommentDTO updateComment(Long commentId, CommentDTO comment);
}
