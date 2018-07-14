package com.example.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.Customer;
import com.example.service.CustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

  CustomerService customerService;

  //  public List<Customer> getCustomers() {
  //    List<Customer> customers = customerService.findAll();
  //    return customers;
  //
  //  }
  @GetMapping
  public Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
    Page<Customer> customers = customerService.findAll(pageable);
    return customers;

  }

  @GetMapping(path = "{id}")
  public Customer getCustomer(@PathVariable Integer id) {
    Customer customer = customerService.findOne(id);
    return customer;

  }

  @PostMapping
  public ResponseEntity<Customer> CustomerpostCustomers(@RequestBody Customer customer,
      UriComponentsBuilder uriBuilder) {
    Customer created = customerService.update(customer);
    URI location = uriBuilder.path("api/customers/{id}")
        .buildAndExpand(created.getId()).toUri();
    return ResponseEntity.created(location).body(created);
  }
  //  @PostMapping
  //  @ResponseStatus(HttpStatus.CREATED)
  //  public Customer postCustomers(@RequestBody Customer customer) {
  //    return customerService.create(customer);
  //
  //  }

  @PutMapping(path = "{id}")

  public Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
    customer.setId(id);
    return customerService.update(customer);

  }

  @DeleteMapping(path = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable Integer id) {
    customerService.delete(id);
  }
}
