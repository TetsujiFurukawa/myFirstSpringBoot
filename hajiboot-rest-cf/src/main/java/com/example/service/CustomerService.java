package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {

  CustomerRepository customerRepository;

  public Page<Customer> findAll(Pageable pageable) {
    return customerRepository.findAllOrderByName(pageable);

  }

  public Customer findOne(Integer id) {
    Customer customer = customerRepository.findOne(id);
    return customer;
  }

  public Customer create(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer update(Customer customer) {
    return customerRepository.save(customer);
  }

  public void delete(Integer id) {
    customerRepository.delete(id);
  }
}
