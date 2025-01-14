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

    private final PostRepository postRepository;

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
        return convertToPostDTO(savedPost);
    }

    @Override
    public List<PostDTO> getPosts() {
        // 1. get the list of posts from the database
        List<Post> posts = postRepository.findAll();

        // 2. convert the list of posts to a list of PostDTOs
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
            postDTOS.add(convertToPostDTO(post));
        }
        // 3. return the list of PostDTOs
        return List.of();
    }

    @Override
    public PostDTO getPost(Long id) {
        // 1. get the post from the database based on id
        // TODO we need to create a custom exception class
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        // 2. convert the post to a PostDTO
        // 3. return the PostDTO
        return convertToPostDTO(post);
    }

    @Override
    public PostDTO2nd getPost2nd(Long id) {
        // 1. get the post from the database based on id
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        // 2. convert the post to a PostDTO
        PostDTO2nd postDTO2nd = new PostDTO2nd();
        postDTO2nd.setId(post.getId());
        postDTO2nd.setTitle(post.getTitle());
        // 3. return the PostDTO
        return postDTO2nd;
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        // 1. retrieve the post from the database
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        // 2. update the post with the new values
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        // 2.1 save the updated post to the database
        Post savedPost = this.postRepository.save(post);

        // 3. convert and return the updated post
        return convertToPostDTO(savedPost);
    }

    @Override
    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }

    private PostDTO convertToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        post.setDescription(postDTO.getDescription());
        return postDTO;
    }

}
