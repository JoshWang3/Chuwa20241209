package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getPosts();

    PostDTO getPost(Long postId);

    PostDTO2nd getPost2nd(Long postId);

    PostDTO updatePost(Long postId, PostDTO postDTO);

    void deletePost(Long postId);
}
