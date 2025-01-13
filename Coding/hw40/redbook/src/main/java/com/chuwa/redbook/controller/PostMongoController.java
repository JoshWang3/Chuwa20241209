package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTOMongo;
import com.chuwa.redbook.service.PostMongoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/mongo/posts")
public class PostMongoController {

    private final PostMongoService postMongoService;

    public PostMongoController(PostMongoService postMongoService) {
        this.postMongoService = postMongoService;
    }

    @PostMapping
    public ResponseEntity<PostDTOMongo> createPost(@RequestBody PostDTOMongo post) {
        PostDTOMongo response = postMongoService.createPost(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDTOMongo>> getAllPosts() {
        List<PostDTOMongo> response = postMongoService.getPosts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTOMongo> getPostById(@PathVariable String id) {
        return new ResponseEntity<>(postMongoService.getPostById(id), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PostDTOMongo> updatePost(@PathVariable String id, @RequestBody PostDTOMongo post) {
        PostDTOMongo response = postMongoService.updatePost(id, post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        postMongoService.deletePost(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
