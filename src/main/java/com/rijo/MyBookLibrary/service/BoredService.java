package com.rijo.MyBookLibrary.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rijo.MyBookLibrary.exception.RestTemplateExceptionHandler;
import com.rijo.MyBookLibrary.model.Bored;


@Service
public class BoredService {
	public String showRandomActivities() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateExceptionHandler());
		String fooResourceUrl = "https://www.boredapi.com/api/activity";
		Bored bored = restTemplate.getForEntity(fooResourceUrl, Bored.class).getBody();
		return bored.getActivity();
	}
}
