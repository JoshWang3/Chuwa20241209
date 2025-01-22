package com.chuwa.redbook.dao.mongo;

import com.chuwa.redbook.entity.PostMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepositoryMongo extends MongoRepository<PostMongo, String> {
}
