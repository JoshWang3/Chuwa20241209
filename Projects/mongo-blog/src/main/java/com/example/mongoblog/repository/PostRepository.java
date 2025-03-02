package com.example.mongoblog.repository;

import com.example.mongoblog.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
