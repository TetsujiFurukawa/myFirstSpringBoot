package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}