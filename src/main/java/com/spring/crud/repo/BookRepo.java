package com.spring.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
