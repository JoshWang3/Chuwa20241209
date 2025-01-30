package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author b1go
 * @date 6/23/22 11:14 PM
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    /**
     * use this modelMapper to replace the mapToDto, mapToEntity methods.
     */
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        // ADDED: Validate commentDto input
        if (commentDto == null) {
            throw new IllegalArgumentException("CommentDto cannot be null");
        }

        Comment comment = modelMapper.map(commentDto, Comment.class);

        // Changed: Validate postId before retrieving the post
        if (postId <= 0) {
            throw new IllegalArgumentException("Post ID must be greater than 0");
        }

        // retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // set post to comment entity
        comment.setPost(post);

        // Added: Validate comment fields before saving
        if (comment.getName() == null || comment.getName().isEmpty()) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment name cannot be empty");
        }

        // comment entity to DB
        Comment savedComment = commentRepository.save(comment);

        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        // Changed: Validate postId before retrieving comments
        if (postId <= 0) {
            throw new IllegalArgumentException("Post ID must be greater than 0");
        }

        // retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        // Added: Check if comments list is empty
        if (comments.isEmpty()) {
            throw new ResourceNotFoundException("Comments", "postId", postId);
        }

        // convert list of comment entities to list of comment dto's
        return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        // Changed: Validate postId and commentId
        if (postId <= 0 || commentId <= 0) {
            throw new IllegalArgumentException("Post ID and Comment ID must be greater than 0");
        }

        // retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        // 业务逻辑
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDtoRequest) {
        // Changed: Validate postId, commentId, and commentDtoRequest
        if (postId <= 0 || commentId <= 0) {
            throw new IllegalArgumentException("Post ID and Comment ID must be greater than 0");
        }

        // retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        // 业务逻辑
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        // Added: Validate comment fields before updating
        if (commentDtoRequest.getName() == null || commentDtoRequest.getName().isEmpty()) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment name cannot be empty");
        }

        comment.setName(commentDtoRequest.getName());
        comment.setEmail(commentDtoRequest.getEmail());
        comment.setBody(commentDtoRequest.getBody());

        Comment updatedComment = commentRepository.save(comment);

        return modelMapper.map(updatedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        // Changed: Validate postId and commentId
        if (postId <= 0 || commentId <= 0) {
            throw new IllegalArgumentException("Post ID and Comment ID must be greater than 0");
        }

        // retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        commentRepository.delete(comment);
    }

    public static CommentDto commentServiceMapperUtil(Comment comment) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(comment, CommentDto.class);
    }
}
