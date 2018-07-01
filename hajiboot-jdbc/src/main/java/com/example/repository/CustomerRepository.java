package com.example.repository;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;

import lombok.AllArgsConstructor;

@Repository
@Transactional
@AllArgsConstructor
public class CustomerRepository {
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
    Integer id = rs.getInt("id");
    String firstName = rs.getString("first_name");
    String lastName = rs.getString("last_name");
    return new Customer(id, firstName, lastName);
  };

  public List<Customer> findAll() {
    List<Customer> customers = namedParameterJdbcTemplate.query(
        "SELECT id, first_name, last_name FROM customers ORDER BY id", customerRowMapper);
    return customers;
  }

  public Customer findOne(Integer customerId) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("id", customerId);

    return namedParameterJdbcTemplate.queryForObject(
        "SELECT id, first_name, last_name FROM  customer WHERE id = :id",
        sqlParameterSource, customerRowMapper);
  }

  public Customer save(Customer customer) {
    SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(customer);
    if (customer.getId() == null) {
      namedParameterJdbcTemplate.update(
          "INSERT INTO customers(first_name, last_name) values(:firstName, :lastName)", sqlParameterSource);

    } else {
      namedParameterJdbcTemplate.update(
          "UPDATE customers SET first_name=:firstName, last_name=:lastName WHERE id = :id", sqlParameterSource);
    }
    return customer;
  }

  public void delete(Integer customerId) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("id", customerId);
    namedParameterJdbcTemplate.update("DELETE FROM customers WHERE id = :id", sqlParameterSource);

  }
}
