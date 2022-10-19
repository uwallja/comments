package com.janettewallace.comments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janettewallace.comments.model.User;

//interface
//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email); //find user by email
}