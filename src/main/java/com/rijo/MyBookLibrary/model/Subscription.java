package com.rijo.MyBookLibrary.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Subscription {

	@Id
	@Column(name = "SUBSCRIBER_NAME")
	@NotEmpty(message = "Please provide a Subscriber name")
	private String subscriberName;

	@Column(name = "DATE_SUBSCRIBED")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@NotNull(message = "Please provide Subscription Date")
	private Date dateSubscribed;

	@Column(name = "DATE_RETURNED")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateReturned;

	@Column(name = "BOOK_ID")
	@NotEmpty(message = "Please provide a Book ID")
	private String bookId;

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public Date getDateSubscribed() {
		return dateSubscribed;
	}

	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

}
