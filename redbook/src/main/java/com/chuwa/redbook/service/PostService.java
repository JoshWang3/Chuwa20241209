package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getPosts();

    PostDTO getPost(long postId);

    PostDTO2nd getPost2nd(long postId);


    PostDTO updatePost(long id, PostDTO postDTO);

    void deletePost(long postId);
}
