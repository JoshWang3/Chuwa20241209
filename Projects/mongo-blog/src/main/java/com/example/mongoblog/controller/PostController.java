package com.example.mongoblog.controller;

import com.example.mongoblog.entity.Post;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED).getBody();
    }
}
