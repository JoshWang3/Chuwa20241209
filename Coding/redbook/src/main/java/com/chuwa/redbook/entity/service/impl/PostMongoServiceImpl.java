package com.chuwa.redbook.entity.service.impl;

import com.chuwa.redbook.dao.mongo.PostRepositoryMongo;
import com.chuwa.redbook.entity.PostMongo;
import com.chuwa.redbook.payload.PostDTOMongo;
import com.chuwa.redbook.entity.service.PostMongoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostMongoServiceImpl implements PostMongoService {

    private final PostRepositoryMongo postRepositoryMongo;

    public PostMongoServiceImpl(PostRepositoryMongo postRepositoryMongo) {
        this.postRepositoryMongo = postRepositoryMongo;
    }

    @Override
    public PostDTOMongo createPost(PostDTOMongo postDTO) {
        PostMongo postMongo = new PostMongo();
        postMongo.setTitle(postDTO.getTitle());
        postMongo.setContent(postDTO.getContent());
        postMongo.setDescription(postDTO.getDescription());
        postMongo.setUserId(postDTO.getUserId());

        postMongo = postRepositoryMongo.save(postMongo);

        postDTO.setId(postMongo.getId());
        return postDTO;
    }

    @Override
    public List<PostDTOMongo> getPosts() {
        List<PostMongo> list = postRepositoryMongo.findAll();
        return list.stream().map(post -> new PostDTOMongo(post.getId(), post.getTitle(), post.getContent(), post.getDescription(), post.getUserId())).toList();
    }

    @Override
    public PostDTOMongo getPostById(String postId) {
        Optional<PostMongo> postMongo = postRepositoryMongo.findById(postId);
        postMongo.orElseThrow(RuntimeException::new);

        PostDTOMongo postDTO = new PostDTOMongo();
        postDTO.setId(postMongo.get().getId());
        postDTO.setTitle(postMongo.get().getTitle());
        postDTO.setContent(postMongo.get().getContent());
        postDTO.setDescription(postMongo.get().getDescription());
        postDTO.setUserId(postMongo.get().getUserId());

        return postDTO;
    }

    @Override
    public PostDTOMongo updatePost(String postId, PostDTOMongo postDTO) {
        Optional<PostMongo> postMongo = postRepositoryMongo.findById(postId);
        postMongo.orElseThrow(RuntimeException::new);

        postMongo.get().setTitle(postDTO.getTitle());
        postMongo.get().setContent(postDTO.getContent());
        postMongo.get().setDescription(postDTO.getDescription());
        postRepositoryMongo.save(postMongo.get());

        postDTO.setId(postMongo.get().getId());

        return postDTO;
    }

    @Override
    public void deletePost(String postId) {
        postRepositoryMongo.deleteById(postId);
    }
}