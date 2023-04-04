package com.example.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Annotation.ValidCustomerList;
import com.example.model.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	@Autowired
    CustomerService service;
	
	@PostMapping(value="/getCustomers",consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getSortedCustomer(@RequestBody List<Customer> customers) {
		//Collections are more Memory Efficient.
        Collections.sort(customers, Comparator.comparing(Customer::getDuetime)); 
       return  customers;
       
    }
	@PostMapping(value="/getCustomersData",consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> sortCustomersUsingStreams(@RequestBody List<Customer> customers) {
      //Streams are more readable.
       return  customers.stream().sorted(Comparator.comparing(Customer::getDuetime)).collect(Collectors.toList());
      
    }
	@PostMapping(value="/getCustomersList",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> sortCustomers(@ValidCustomerList @RequestBody List<Customer> customersList) {
	    List<Customer> list = service.getAllCustomer(customersList);
	          return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
    
      }
}
