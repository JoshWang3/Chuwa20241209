package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.payload.PageDTO;
import com.chuwa.redbook.service.CommentService;
import com.chuwa.redbook.util.mapper.CustomizedMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
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
        Comment commentDB = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        return CustomizedMapper.commentServiceMapperUtil(commentDB);
    }

    @Override
    public CommentDTO getCommentByIds(Long postId, Long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment commentDB = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!post.getId().equals(commentDB.getPostId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return CustomizedMapper.commentServiceMapperUtil(commentDB);
    }

    @Override
    public PageDTO<CommentDTO> getCommentList(Long postId, int startPage, int pageSize) {
        Page<Comment> curPage = commentRepository.findByPostId(postId, PageRequest.of(startPage, pageSize));

        if (!curPage.hasContent()) {
            throw new ResourceNotFoundException("Comment", "postId", postId);
        }

        PageDTO<CommentDTO> returnPage = new PageDTO<CommentDTO>();
        returnPage.setLast(curPage.isLast());
        returnPage.setTotalPages(curPage.getTotalPages());
        returnPage.setTotalElements(curPage.getTotalElements());
        returnPage.setHasNext(curPage.hasNext());
        returnPage.setNumber(curPage.getNumber());
        returnPage.setData(curPage.get()
                .map(CustomizedMapper::commentServiceMapperUtil)
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
        Comment commentDB = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        commentDB.setContent(comment.getContent());
        commentRepository.save(commentDB);
        comment.setId(commentDB.getId());

        return comment;
    }
}
