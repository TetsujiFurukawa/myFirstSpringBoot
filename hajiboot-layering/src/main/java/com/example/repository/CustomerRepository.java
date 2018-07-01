package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.example.domain.Customer;

@Repository
public class CustomerRepository {
  private final ConcurrentMap<Integer, Customer> coustomerMap = new ConcurrentHashMap<>();

  public List<Customer> findAll() {
    return new ArrayList<>(coustomerMap.values());
  }

  public Customer findOne(Integer customerId) {
    return coustomerMap.get(customerId);
  }

  public Customer sava(Customer customer) {
    return coustomerMap.put(customer.getId(), customer);
  }

  public void delete(Integer custonerId) {
    coustomerMap.remove(custonerId);
  }
}
