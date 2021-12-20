package com.rijo.MyBookLibrary.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class BookControllerTest {
	
	@Autowired
    private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
	}

	@Test
	public void controllerConfigurationTest() throws Exception {
		this.mvc.perform(get("/books").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	
	@Test
	public void initialBookLoadTest() throws Exception {
		this.mvc.perform(get("/books").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(content().json("[{\"bookId\":\"B1212\",\"bookName\":\"Ross Suarez\",\"author\":\"History of Amazon Valley\",\"availableCopies\":0,\"totalCopies\":2},{\"bookId\":\"B4232\",\"bookName\":\"H S Parkmay\",\"author\":\"Language Fundamentals\",\"availableCopies\":5,\"totalCopies\":5}]"));
	}
	
}
