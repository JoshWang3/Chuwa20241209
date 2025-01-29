package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostGraphQLController {

    private final PostService postService;

    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDTO postById(@Argument long id) {
        return postService.getPostById(id);
    }

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String content, @Argument String description) {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setContent(content);
        postDTO.setDescription(description);

        return postService.createPost(postDTO);
    }

    @MutationMapping
    public PostDTO updatePost(@Argument long id, @Argument String title, @Argument String content, @Argument String description) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(id);
        postDTO.setTitle(title);
        postDTO.setContent(content);
        postDTO.setDescription(description);

        return postService.updatePost(id, postDTO);
    }
}
