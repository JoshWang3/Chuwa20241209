package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Comment;
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

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getComments() {
        List<CommentDTO> commentDTOList = commentService.getComments();
        return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long commentId) {
        CommentDTO commentDTO = commentService.getCommentById(commentId);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO) {
        commentService.addComment(commentDTO);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO) {
        commentService.updateComment(commentId, commentDTO);
        return new ResponseEntity<>("udpated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}
