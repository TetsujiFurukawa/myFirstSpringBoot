package com.example.service;

import java.util.Optional;

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
    Optional<Customer> customer = customerRepository.findById(id);
    return customer.orElse(null);
  }

  public Customer create(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer update(Customer customer) {
    return customerRepository.save(customer);
  }

  public void delete(Integer id) {
    customerRepository.deleteById(id);
  }
}
