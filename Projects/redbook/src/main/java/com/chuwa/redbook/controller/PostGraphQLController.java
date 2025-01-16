package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostGraphQLController {
    private PostService postService;

    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDTO postById(@Argument Long id) {
        return postService.getPost(id);
    }

    @QueryMapping
    public List<PostDTO> getAllPost() {
        return postService.getPosts();
    }

    @MutationMapping
    public PostDTO createPost(@Argument String title, @Argument String content, @Argument String description, @Argument Long authorId) {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setContent(content);
        postDTO.setDescription(description);
        postDTO.setAuthorId(authorId);
        return this.postService.createPost(postDTO);

    }

    @MutationMapping
    public PostDTO updatePost(@Argument long id, @Argument String title, @Argument String content, @Argument String description, @Argument Long authorId) {
        PostDTO postDTO = new PostDTO();
        postDTO.setDescription(description);
        postDTO.setContent(content);
        postDTO.setTitle(title);
        postDTO.setAuthorId(authorId);
        return this.postService.updatePost(id, postDTO);
    }
}
