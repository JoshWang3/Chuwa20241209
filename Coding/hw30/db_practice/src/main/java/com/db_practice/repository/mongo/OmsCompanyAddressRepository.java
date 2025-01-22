package com.db_practice.repository.mongo;

import com.db_practice.entity.mongo.OmsCompanyAddressMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OmsCompanyAddressRepository extends MongoRepository<OmsCompanyAddressMongo, String> {
    @Query("{ 'city': ?0 }")
    List<OmsCompanyAddressMongo> findByCustomCriteria(String city);
}
