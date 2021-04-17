package com.brijesh.mongodb.customerservice.repository;

import com.brijesh.mongodb.customerservice.entity.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends MongoRepository<Counter,Long> {
}
