package com.rijo.MyBookLibrary.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rijo.MyBookLibrary.model.Book;
import com.rijo.MyBookLibrary.repository.BookRepository;


public class BookServiceTest {
	
	@InjectMocks
	private BookService bookService; 
	
	@Mock
    private BookRepository bookRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllBooks() {
		when(bookRepository.findAll()).thenReturn(initializeList());
		assertEquals(2, initializeList().size());
	}

	public List<Book> initializeList() {
		List<Book> list = new ArrayList<Book>();
		Book book1 = new Book("B1212", "History of Amazon Valley", "Ross Suarez", 0, 2);
		Book book2 = new Book("B1212", "Language Fundamentals", "H S Parkmay", 5, 5);
		list.add(book1);
		list.add(book2);
		return list;
	}
	
}
