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
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {

        //step 1(convert PostDTO -> Post), create new Post Obj
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        //step 2, save post obj to DB
        Post savedPost = this.postRepository.save(post);

        //step 3 (Covert Post -> PostDTO), convert savedPost obj to PostDTO and return
        return convertPostToPostDTO(savedPost);
    }

    @Override
    public List<PostDTO> getPosts() {
        //1, get the list of posts from DB
        List<Post> posts = this.postRepository.findAll();

        //2, convert list of posts to PostDTO
        //TODO let's optimize it later
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
            postDTOS.add(convertPostToPostDTO(post));
        }

        //3, return the list of PostDTOs
        return postDTOS;
    }

    @Override
    public PostDTO getPost(long postId) {
        //1, retrieve Post from DB based on ID
        //TODO we need create a customized exception.
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id", postId));
        //2, convert Post to PostDTO
        //3, return
        return convertPostToPostDTO(post);
    }

    @Override
    public PostDTO2nd getPost2nd(long postId) {
        //1, get post
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id", postId));
        //2, convert
        PostDTO2nd postDTO2nd = new PostDTO2nd();
        postDTO2nd.setTitle(post.getTitle());
        postDTO2nd.setId(post.getId());

        return postDTO2nd;
    }

    @Override
    public PostDTO updatePost(long postId, PostDTO postDTO) {
        //1, retrieve post
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id", postId));
        //2, update post
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        //bug here - missing
        Post savedPost = this.postRepository.save(post);

        //3,convert & return
        return convertPostToPostDTO(savedPost);
    }

    @Override
    public void deletePost(long postId) {
        this.postRepository.deleteById(postId);
    }

    private PostDTO convertPostToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setDescription(post.getDescription());

        return postDTO;
    }
}
