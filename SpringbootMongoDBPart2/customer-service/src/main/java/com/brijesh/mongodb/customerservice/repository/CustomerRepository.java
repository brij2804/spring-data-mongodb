package com.brijesh.mongodb.customerservice.repository;

import com.brijesh.mongodb.customerservice.entity.Customer;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    public Customer findById(String id);

    @Query(value =  "{ 'firstName' : ?0}")
    public List<Customer> findByFirstName(String firstName);

    @Query(value =  "{ 'lastName' : ?0}")
    public List<Customer> findByLastName(String lastName);

    @Query(value =  "{ 'firstName' : ?0, 'lastName' : ?1 }")
    public List<Customer> findByFirstAndLastName(String firstName,String lastName);


}
