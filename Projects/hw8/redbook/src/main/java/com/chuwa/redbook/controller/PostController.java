package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;
import com.chuwa.redbook.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        PostDTO response = postService.createPost(postDTO);
        return new ResponseEntity<PostDTO>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts() {
        List<PostDTO> response = postService.getPosts();
        return new ResponseEntity<List<PostDTO>>(response, HttpStatus.OK);
    }

    @GetMapping("/jpql")
    public List<PostDto> getAllPostsJPQL() {
        return postService.getAllPostWithJPQL();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @GetMapping("/partial/{id}")
    public ResponseEntity<PostDTO2nd> getPost2ndById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPost2nd(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.updatePost(id, postDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
