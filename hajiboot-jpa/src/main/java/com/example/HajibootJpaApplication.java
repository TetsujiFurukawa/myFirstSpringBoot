package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class HajibootJpaApplication implements CommandLineRunner {

  CustomerRepository customerRepository;

  public static void main(String[] args) {
    SpringApplication.run(HajibootJpaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Customer created = customerRepository.save(new Customer(null, "Nobita", "Nobi"));
    System.out.println(created + " is created");
    created = customerRepository.save(new Customer(null, "Takeshi", "Goda"));
    System.out.println(created + " is created");
    created = customerRepository.save(new Customer(null, "Suneo", "Honekawa"));
    System.out.println(created + " is created");
    created = customerRepository.save(new Customer(null, "Shizuka", "Minamoto"));
    System.out.println(created + " is created");
    created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
    System.out.println(created + " is created");

    Pageable pageable = new PageRequest(0, 3, Direction.DESC, "");
    Page<Customer> page = customerRepository.findAllOrderByName(pageable);

    System.out.println("1ページのデータ数=" + page.getSize());
    System.out.println("現在のページ数=" + page.getNumber());
    System.out.println("全ページ数=" + page.getTotalPages());
    System.out.println("全データ数=" + page.getTotalElements());
    page.getContent()
        .forEach(System.out::println);
  }
}
