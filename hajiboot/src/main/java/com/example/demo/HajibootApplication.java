package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HajibootApplication {

  @GetMapping("/")
  public String home() {
    return "HajiBootApp" + " (" + System.getenv("CF_INSTANCE_INDEX") + ") Ver2";
  }

  @GetMapping("kill")
  public void kill() {
    System.exit(1);
  }

  public static void main(String[] args) {
    SpringApplication.run(HajibootApplication.class, args);
  }
}
