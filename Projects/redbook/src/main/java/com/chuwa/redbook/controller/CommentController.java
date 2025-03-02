package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDTO> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        CommentDTO comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO comment) {
        CommentDTO newComment = commentService.createComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDetails) {
        CommentDTO updatedComment = commentService.updateComment(id, commentDetails);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
