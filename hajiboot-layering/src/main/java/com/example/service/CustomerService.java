package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {

  CustomerRepository customerRepository;

  public Customer save(Customer customer) {
    return customerRepository.sava(customer);
  }

  public List<Customer> findAll() {
    return customerRepository.findAll();

  }
}
