package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.CommentDTO;
import com.chuwa.redbook.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
        CommentDTO response = commentService.create(commentDTO);
        return new ResponseEntity<CommentDTO>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getComments() {
        List<CommentDTO> response = commentService.getComments();
        return new ResponseEntity<List<CommentDTO>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getComment(id), HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO CommentDTO) {
        return new ResponseEntity<>(commentService.updateComment(id, CommentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommentById(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
