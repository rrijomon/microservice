package com.rijo.MyBookLibrary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@Column(name = "BOOK_ID")
	private String bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "AVAILABLE_COPIES")
	private Integer availableCopies;
	
	@Column(name = "TOTAL_COPIES")
	private Integer totalCopies;
	
	public Book() {
		super();
	}

	public Book(String bookId, String bookName, String author, Integer availableCopies, Integer totalCopies) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.availableCopies = availableCopies;
		this.totalCopies = totalCopies;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public Integer getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}
}
