package com.exercise.stream.repo;

import java.util.List;

import com.exercise.stream.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {

    List<Order> findAll();
}