package com.brijesh.mongodb.customerservice.service;

import com.brijesh.mongodb.customerservice.controller.CustomerController;
import com.brijesh.mongodb.customerservice.entity.Counter;
import com.brijesh.mongodb.customerservice.entity.Customer;
import com.brijesh.mongodb.customerservice.repository.CounterRepository;
import com.brijesh.mongodb.customerservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CounterRepository counterRepository;

    public Customer getCustomerById(String id){
        logger.info("getCustomerById()");
        return null;//customerRepository.findById(id);
    }

    public List<Customer> createCustomer(Customer customer){
        logger.info("createCustomer()");
        customerRepository.save(customer);
        return customerRepository.findAll();
    }

    public Long getIdFromCounter(){
        logger.info("getIdFromCounter()");
        List<Counter> counters =counterRepository.findAll();
        Long id = 0l;
        if(!counters.isEmpty()){
            Counter counter = counters.get(0);
            id = counter.getId();
        }
        return id;
    }

    public List<Customer> getAllByFirstName(String firstName) {
        logger.info("getAllByFirstName()");
        return customerRepository.findByFirstName(firstName);
    }

    public List<Customer> getAllByLastName(String lastName) {
        logger.info("getAllCustomerByLastName()");
        return customerRepository.findByLastName(lastName);
    }

    public List<Customer> getAllByFirstAndLastName(String firstName,String lastName) {
        logger.info("getAllByFirstAndLastName()");
        return customerRepository.findByFirstAndLastName(firstName,lastName);
    }


    public List<Customer> getCustomers(Customer customer){
        logger.info("getCustomers()");
       if(customer.getFirstName()!=null && customer.getLastName()==null){
           logger.info("getAllByFirstName()");
           return getAllByFirstName(customer.getFirstName());
       }
       if(customer.getLastName()!=null && customer.getFirstName()==null){
           logger.info("getAllByLastName()");
           return getAllByLastName(customer.getLastName());
       }
       if(customer.getFirstName()!=null && customer.getLastName()!=null){
           logger.info("getAllByFirstAndLastName()");
           return getAllByFirstAndLastName(customer.getFirstName(),customer.getLastName());
       }
         return null;
    }


}
