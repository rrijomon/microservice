package com.rijo.MyBookLibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rijo.MyBookLibrary.model.Book;
import com.rijo.MyBookLibrary.model.Subscription;
import com.rijo.MyBookLibrary.repository.BookRepository;
import com.rijo.MyBookLibrary.repository.SubscriptionRepository;



@Repository
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Subscription> getSubscriberDetails(String subscriber) {
		if (subscriber != null && !subscriber.isEmpty()) {
			List<Subscription> subscribers = new ArrayList<>();
			subscribers.add(subscriptionRepository.findById(subscriber).get());
			return subscribers;
		}
		return null;
	}

	public List<Subscription> getAllSubscriberDetails() {
		return subscriptionRepository.findAll();
	}
	
	@Transactional
	public String createSubscription(Subscription subscription) {
		String message = null;
		if (subscription.getDateReturned() != null) {
			Book book = bookRepository.findById(subscription.getBookId()).get();
			if (book.getAvailableCopies() < book.getTotalCopies()) {
				book.setAvailableCopies(book.getAvailableCopies() + 1);
				bookRepository.saveAndFlush(book);
				subscriptionRepository.saveAndFlush(subscription);
				message = "Book " + book.getBookName() + " has been returned by " + subscription.getSubscriberName();
			} else {
				message = "Invalid Book return, book " + book.getBookName() + " is already at max capacity";
			}
		} else {
			subscriptionRepository.findById(subscription.getSubscriberName()).get();
			String bookId = subscription.getBookId();
			if (bookId != null && !bookId.isEmpty()) {
				Book book = bookRepository.findById(bookId).get();
				if (book.getAvailableCopies() > 0) {
					book.setAvailableCopies(book.getAvailableCopies() - 1);
					bookRepository.saveAndFlush(book);
					subscriptionRepository.saveAndFlush(subscription);
					message = subscription.getSubscriberName() + " has subscribed the Book " + book.getBookName();
				} else {
					message = "Invalid entry, Book " + book.getBookName() + " not available to subscribe";
				}
			}

		}
		return message;
	}

}
