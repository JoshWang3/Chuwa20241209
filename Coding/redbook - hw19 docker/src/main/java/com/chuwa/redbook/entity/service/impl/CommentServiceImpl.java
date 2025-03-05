package com.chuwa.redbook.entity.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.payload.PageDTO;
import com.chuwa.redbook.entity.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDTO addComment(CommentDTO comment) {
        Comment commentDB = new Comment();
        commentDB.setContent(comment.getContent());
        commentDB.setPostId(comment.getPostId());
        commentDB.setUserId(comment.getUserId());

        commentDB = commentRepository.save(commentDB);

        comment.setId(commentDB.getId());
        return comment;
    }

    @Override
    public CommentDTO getComment(Long commentId) {
        Comment commentDB = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        return new CommentDTO(commentDB.getId(), commentDB.getContent(), commentDB.getUserId(), commentDB.getPostId());
    }

    @Override
    public PageDTO<CommentDTO> getCommentList(Long postId, int startPage, int pageSize) {
        Page<Comment> curPage = commentRepository.findByPostId(postId, PageRequest.of(startPage, pageSize));

        PageDTO<CommentDTO> returnPage = new PageDTO<CommentDTO>();
        returnPage.setLast(curPage.isLast());
        returnPage.setTotalPages(curPage.getTotalPages());
        returnPage.setTotalElements(curPage.getTotalElements());
        returnPage.setHasNext(curPage.hasNext());
        returnPage.setNumber(curPage.getNumber());
        returnPage.setData(curPage.get()
                .map(comment -> new CommentDTO(comment.getId(), comment.getContent(), comment.getUserId(), comment.getPostId()))
                .toList()
        );

        return returnPage;
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public CommentDTO updateComment(Long commentId, CommentDTO comment) {
        Comment commentDB = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
        commentDB.setContent(comment.getContent());

        commentRepository.save(commentDB);

        comment.setId(commentDB.getId());

        return comment;
    }
}
