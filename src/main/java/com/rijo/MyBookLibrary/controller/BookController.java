package com.rijo.MyBookLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rijo.MyBookLibrary.model.Book;
import com.rijo.MyBookLibrary.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}
}
