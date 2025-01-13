package com.chuwa.mongo_blog.DAO;

import com.chuwa.mongo_blog.Entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}