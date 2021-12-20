package com.rijo.MyBookLibrary.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class SubscriptionControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(new SubscriptionController()).build();
	}

	@Test
	public void controllerConfigurationTest() throws Exception {
		this.mvc.perform(get("/subscriptions").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void initialBookLoadTest() throws Exception {
		this.mvc.perform(get("/subscriptions").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(
						"[{\"subscriberName\":\"John\",\"dateSubscribed\":\"2020-06-12\",\"dateReturned\":null,\"bookId\":\"B1212\"},{\"subscriberName\":\"Mark\",\"dateSubscribed\":\"2020-04-26\",\"dateReturned\":\"2020-05-14\",\"bookId\":\"B4232\"},{\"subscriberName\":\"Peter\",\"dateSubscribed\":\"2020-06-22\",\"dateReturned\":null,\"bookId\":\"B1212\"}]"));
	}

	@Test
	public void filterSubscriptionResult() throws Exception {
		this.mvc.perform(get("/subscriptions").param("subscriber", "Peter").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(
						"[{\"subscriberName\":\"Peter\",\"dateSubscribed\":\"2020-06-22\",\"dateReturned\":null,\"bookId\":\"B1212\"}]"));
	}

	@Test
	public void returnBook() throws Exception {
		this.mvc.perform(post("/subscriptions").content(
				"{\"subscriberName\":\"Peter\",\"dateSubscribed\":\"2020-06-22\",\"dateReturned\":\"2020-06-25\",\"bookId\":\"B1212\"}")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Book History of Amazon Valley has been returned by Peter"));
	}
	
	@Test
	public void subscribeABook() throws Exception {
		this.mvc.perform(post("/subscriptions").content(
				"{\"subscriberName\":\"Peter\",\"dateSubscribed\":\"2021-12-05\",\"dateReturned\":null,\"bookId\":\"B1212\"}")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Peter has subscribed the Book History of Amazon Valley"));
	}
	
}
