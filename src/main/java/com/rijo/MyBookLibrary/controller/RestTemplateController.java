package com.rijo.MyBookLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rijo.MyBookLibrary.service.BoredService;


@RestController
public class RestTemplateController {
	@Autowired
	private BoredService boredService;

	@GetMapping("/bored")
	public String showActivities() {
		return boredService.showRandomActivities();
	}
}
