package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class HajibootJdbcApplication implements CommandLineRunner {

  CustomerRepository customerRepository;

  public static void main(String[] args) {
    SpringApplication.run(HajibootJdbcApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
    System.out.println(created + " is created");

    customerRepository.findAll()
        .forEach(System.out::println);
  }
}
