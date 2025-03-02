package com.chuwa.redbook.entity.service;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getPosts();

    PostDTO getPostById(long postId);

    PostDTO2nd getPost2nd(long postId);

    PostDTO updatePost(long postId, PostDTO postDTO);

    void deletePost(long postId);
}
