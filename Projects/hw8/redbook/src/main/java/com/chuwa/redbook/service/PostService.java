package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDTO;
import com.chuwa.redbook.payload.PostDTO2nd;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getPosts();

    PostDTO getPost(Long id);

    PostDTO2nd getPost2nd(Long id);

    PostDTO updatePost(Long id, PostDTO postDTO);

    void deletePost(Long id);

    List<PostDto> getAllPostWithJPQL();
}
