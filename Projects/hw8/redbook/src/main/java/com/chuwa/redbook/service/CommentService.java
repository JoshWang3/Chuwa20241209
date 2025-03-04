package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.payload.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO create(CommentDTO commentDTO);
    List<CommentDTO> getComments();

    CommentDTO getComment(Long id);

    CommentDTO updateComment(Long id, CommentDTO commentDTO);

    void deleteComment(Long id);
}
