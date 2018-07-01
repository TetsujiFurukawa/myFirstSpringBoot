package com.example.web.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "users")
@ToString(exclude = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @Column(name = "username")
  private String username;

  @JsonIgnore
  @Column(name = "encoded_password")
  private String encodePassword;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
  private List<Customer> customers;

}
