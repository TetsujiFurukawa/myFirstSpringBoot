package com.example.web.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
  @GetMapping(path = "loginForm")
  public String loginForm() {
    return "loginForm";
  }
}
