package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        Author author = new Author();
        author.setId(postDTO.getAuthorId());
        post.setAuthor(author);
        Post newPost = postRepository.save(post);

        return convertPostToPostDTO(newPost);

    }

    @Override
    public List<PostDTO> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
            postDTOS.add(convertPostToPostDTO(post));
        }
        return postDTOS;
    }

    @Override
    public PostDTO getPost(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));

        return convertPostToPostDTO(post);
    }

    @Override
    public PostDTO updatePost(long postId, PostDTO postDTO) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        Author author = new Author();
        author.setId(postDTO.getAuthorId());
        post.setAuthor(author);

        return convertPostToPostDTO(postRepository.save(post));

    }

    @Override
    public void deletePost(long postId) {
        postRepository.deleteById(postId);
    }

    private PostDTO convertPostToPostDTO(Post post) {
        PostDTO postResponse = new PostDTO();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setDescription(post.getDescription());
        postResponse.setContent(post.getContent());
        postResponse.setAuthorId(post.getAuthor().getId());
        return postResponse;
    }
}
