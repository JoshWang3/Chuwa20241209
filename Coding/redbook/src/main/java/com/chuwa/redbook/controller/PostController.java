package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
}
