package com.spring.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.model.Book;
import com.spring.crud.repo.BookRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookRepo bookRepo;

	@PostMapping("/add-book")
	public String addBook(@RequestBody Book b) {

		bookRepo.save(b);
		return "BOOK SUCCESSFULLY ADDED";
	}

	@GetMapping("/get-book/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		Optional<Book> b = bookRepo.findById(id);
		return b.get();
	}

	@GetMapping("/get-all-book")
	public List<Book> getAllBook() {
		List<Book> allBooks = bookRepo.findAll();
		return allBooks;
	}

	@PutMapping("/update-book")
	public Book updateBook(@RequestBody Book b) {
		bookRepo.save(b);
		return bookRepo.findById(b.getBOOK_ID()).get();
	}

	@DeleteMapping("/delete-book/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookRepo.deleteById(id);
		return "BOOK DELETED";
	}

}
