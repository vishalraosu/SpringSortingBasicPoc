package com.example.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.model.Customer;

@Service
public class CustomerService {

	public List<Customer> getAllCustomer(List<Customer> customers) {
       return  customers.stream().sorted(Comparator.comparing(Customer::getDuetime)).collect(Collectors.toList());
	}
	

}
