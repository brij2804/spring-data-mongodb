package com.brijesh.mongodb.customerservice.service;

import com.brijesh.mongodb.customerservice.entity.Counter;
import com.brijesh.mongodb.customerservice.entity.Customer;
import com.brijesh.mongodb.customerservice.repository.CounterRepository;
import com.brijesh.mongodb.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CounterRepository counterRepository;

    public Customer getCustomerById(String id){
        return customerRepository.findById(id);
    }

    public List<Customer> createCustomer(Customer customer){
        customerRepository.save(customer);
        return customerRepository.findAll();
    }

    public Long getIdFromCounter(){
        List<Counter> counters =counterRepository.findAll();
        Long id = 0l;
        if(!counters.isEmpty()){
            Counter counter = counters.get(0);
            id = counter.getId();
        }
        return id;
    }


}
