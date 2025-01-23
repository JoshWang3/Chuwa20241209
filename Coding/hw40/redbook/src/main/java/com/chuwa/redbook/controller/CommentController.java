package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.payload.PageDTO;
import com.chuwa.redbook.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO comment) {
        CommentDTO response = commentService.addComment(comment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/post-id")
    public ResponseEntity<PageDTO<CommentDTO>> getAllCommentsByPostId(@RequestBody PageDTO pageDTO) {
        PageDTO<CommentDTO> response = commentService.getCommentList(pageDTO.getQueryId(), pageDTO.getStartPage(), pageDTO.getPageSize());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getComment(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO comment) {
        CommentDTO response = commentService.updateComment(id, comment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
