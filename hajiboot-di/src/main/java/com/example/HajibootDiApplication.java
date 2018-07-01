package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class HajibootDiApplication implements CommandLineRunner {

  ArgumentResolver argumentResolver;

  Calculator calculator;

  public static void main(String[] args) {
    SpringApplication.run(HajibootDiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("Enter 2 numbers like 'a b'): ");
    Argument argument = argumentResolver.resolve(System.in);

    int result = calculator.calc(argument.getA(), argument.getB());
    System.out.println("result=" + result);

  }
}
