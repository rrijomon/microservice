package com.rijo.MyBookLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rijo.MyBookLibrary.model.Subscription;
import com.rijo.MyBookLibrary.service.SubscriptionService;


@RestController
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping("/subscriptions")
	public List<Subscription> getSubscriberDetails(@RequestParam(value="subscriber", required = false) String subscriber) {
		if (subscriber != null && !subscriber.isEmpty()) {
			return subscriptionService.getSubscriberDetails(subscriber);
		}
		else {
			return subscriptionService.getAllSubscriberDetails();
		}
	}
	
	@PostMapping("/subscriptions")
	public String createSubscription(@RequestBody Subscription subscription) {
		return subscriptionService.createSubscription(subscription);
	}

}
