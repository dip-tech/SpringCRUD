package com.spring.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.model.User;

public interface UserRepo extends JpaRepository<User, String> {

}
