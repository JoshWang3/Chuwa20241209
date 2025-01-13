package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;
import com.chuwa.redbook.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO){

        // 1. create a new Post Obj
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        // 2. save the post obj to DB
        Post savedPost = this.postRepository.save(post);

        // 3. convert Post -> PostDTO and return
//        PostDTO response = new PostDTO();
//        response.setId(savedPost.getId());
//        response.setTitle(savedPost.getTitle());
//        response.setContent(savedPost.getContent());
//        response.setDescription(savedPost.getDescription());
//        return response;
        return convertPostToPostDTO(savedPost);
    }

    @Override
    public List<PostDTO> getPosts() {
        // 1. get the list of posts from db
        List<Post> posts = this.postRepository.findAll();

        // 2. convert list of posts to PostDTO
        // need optimization
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
//            PostDTO postDTO = new PostDTO();
//            postDTO.setId(post.getId());
//            postDTO.setTitle(post.getTitle());
//            postDTO.setContent(post.getContent());
//            postDTO.setDescription(post.getDescription());
//            postDTOS.add(postDTO);
            postDTOS.add(convertPostToPostDTO(post));
        }
        // return the list of Post DTO
        return postDTOS;
    }

    @Override
    public PostDTO getPost(long postId) {
        //1. get post from DB by ID
        // need exception
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id", postId));

        return convertPostToPostDTO(post);
    }

    @Override
    public PostDTO2nd getPost2nd(long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id", postId));

        PostDTO2nd postDTO2nd = new PostDTO2nd();
        postDTO2nd.setTitle(post.getTitle());
        postDTO2nd.setId(post.getId());

        return postDTO2nd;
    }


    private PostDTO convertPostToPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setDescription(post.getDescription());

        return postDTO;
    }


    @Override
    public PostDTO updatePost(long postId, PostDTO postDTO){

        // retrieve post
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id", postId));
        // update post
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        Post savedPost = this.postRepository.save(post);

        // return
        return convertPostToPostDTO(savedPost);
    }

    @Override
    public void deletePost(long postId) {
        this.postRepository.deleteById(postId);
    }
}
