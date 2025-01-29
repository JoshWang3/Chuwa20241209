package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;
import com.chuwa.redbook.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Post APIs")
@RestController
@RequestMapping("/api/v2/posts")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "Create Post", description = "Returns a ResponseEntity")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO post) {
        PostDTO response = postService.createPost(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Get All Post", description = "Returns all Posts")
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> response = postService.getPosts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("/partial/{id}")
    public ResponseEntity<PostDTO2nd> getPost2ndById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPost2nd(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id, @RequestBody PostDTO post) {
        PostDTO response = postService.updatePost(id, post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PostConstruct
    public void checkProxy() {
        logger.info("Is myService a proxy? {}", AopUtils.isAopProxy(postService));
    }
}
