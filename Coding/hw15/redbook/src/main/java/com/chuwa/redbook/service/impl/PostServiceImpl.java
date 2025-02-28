package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;
import com.chuwa.redbook.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        // create new post
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        post.setUserId(postDTO.getUserId());

        // save post
        Post savedPost = postRepository.save(post);

        // convert savePost obj to PostDTO and return
        postDTO.setId(savedPost.getId());

        return postDTO;
    }

    @Override
    public List<PostDTO> getPosts() {
        // get the list of post from db
        List<Post> posts = postRepository.findAll();

        // return the list of PostDTOs
        return posts.stream()
            .map(post -> new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getDescription(), post.getUserId()))
            .toList();
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("POST", "id", id));
        return ConvertPostDTO(post);
    }

    @Override
    public PostDTO2nd getPost2nd(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("POST", "id", postId));
        return new PostDTO2nd(post.getTitle(), post.getId());
    }

    @Override
    public PostDTO updatePost(long postId, PostDTO postDTO) {
        // 1. retrieve post
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("POST", "id", postId));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        // 2. save post
        Post savedPost = postRepository.save(post);

        return new PostDTO(savedPost.getId(), savedPost.getTitle(), savedPost.getContent(), savedPost.getDescription(), savedPost.getUserId());
    }

    @Override
    public void deletePost(long postId) {
        postRepository.deleteById(postId);
    }

    private PostDTO ConvertPostDTO(Post post) {
        return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getDescription(), post.getUserId());
    }
}
