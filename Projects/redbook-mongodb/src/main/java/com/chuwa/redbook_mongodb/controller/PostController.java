package com.chuwa.redbook_mongodb.controller;


import com.chuwa.redbook_mongodb.dao.PostRepository;
import com.chuwa.redbook_mongodb.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post response = postRepository.save(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
