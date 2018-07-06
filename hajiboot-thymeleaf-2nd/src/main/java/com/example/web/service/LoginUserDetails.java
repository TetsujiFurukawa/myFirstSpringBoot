package com.example.web.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.web.domain.User;

import lombok.Data;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
  private final User user;

  public LoginUserDetails(User user) {
    super(user.getUsername(), user.getEncodePassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    this.user = user;
  }
}
