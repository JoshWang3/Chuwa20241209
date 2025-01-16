package com.chuwa.redbook_mongodb.dao;

import com.chuwa.redbook_mongodb.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}