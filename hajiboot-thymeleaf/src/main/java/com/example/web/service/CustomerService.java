package com.example.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.web.domain.Customer;
import com.example.web.domain.User;
import com.example.web.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {

  CustomerRepository customerRepository;

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  /** overload */
  public Page<Customer> findAll(Pageable pageable) {
    return customerRepository.findAllOrderByName(pageable);
  }

  public Customer findOne(Integer id) {
    Customer customer = customerRepository.findOne(id);
    return customer;
  }

  public Customer create(Customer customer, User user) {
    customer.setUser(user);
    return customerRepository.save(customer);
  }

  public Customer update(Customer customer, User user) {
    customer.setUser(user);
    return customerRepository.save(customer);
  }

  public void delete(Integer id) {
    customerRepository.delete(id);
  }
}
