package com.brijesh.mongodb.customerservice.controller;

import com.brijesh.mongodb.customerservice.entity.Customer;
import com.brijesh.mongodb.customerservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer-service/customer/{id}")
    public Customer getCustomerbyId(@PathVariable String id){
        logger.info("getCustomerbyId()");
        logger.info("path : "+"/customer-service/customer/{id}");
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customer-service/customer")
    public List<Customer> createCustomer(@RequestBody Customer customer){
        logger.info("createCustomer()");
        logger.info("path : "+"/customer-service/customer");
       return customerService.createCustomer(customer);
    }

    @GetMapping("/customer-service/customer/getIdFromCounter")
    public Long getIdFromCounter(){
        logger.info("getIdFromCounter()");
        logger.info("path : "+"/customer-service/customer/getIdFromCounter");
        return customerService.getIdFromCounter();
    }

    @GetMapping("/customer-service/customer")
    public List<Customer> getCustomers(@RequestBody Customer customer){
        logger.info("getCustomers()");
        logger.info("path : "+"/customer-service/customer");
        return customerService.getCustomers(customer);
    }

}
