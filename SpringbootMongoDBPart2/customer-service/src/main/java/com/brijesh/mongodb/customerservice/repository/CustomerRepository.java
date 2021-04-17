package com.brijesh.mongodb.customerservice.repository;

import com.brijesh.mongodb.customerservice.entity.Customer;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    public Customer findById(String id);
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
