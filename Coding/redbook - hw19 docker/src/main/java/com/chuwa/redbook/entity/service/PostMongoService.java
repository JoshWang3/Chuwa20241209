package com.chuwa.redbook.entity.service;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTOMongo;

import java.util.List;

public interface PostMongoService {
    PostDTOMongo createPost(PostDTOMongo postDTO);

    List<PostDTOMongo> getPosts();

    PostDTOMongo getPostById(String postId);

    PostDTOMongo updatePost(String postId, PostDTOMongo postDTO);

    void deletePost(String postId);
}
