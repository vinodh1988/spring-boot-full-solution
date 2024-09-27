package com.bootapps.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapps.entitities.User;



public interface UserRepository extends JpaRepository<User, String> {
  public User findUserByUsername(String username);
}
