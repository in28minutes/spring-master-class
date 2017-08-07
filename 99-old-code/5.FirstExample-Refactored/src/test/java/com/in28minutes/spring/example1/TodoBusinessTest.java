package com.in28minutes.spring.example1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.spring.example1.businessservice.TodoBusinessService;

@Configuration
@ComponentScan(basePackages = {
		"com.in28minutes.spring.example1.businessservice",
		"com.in28minutes.spring.example1.dataservice.stub" })
class SpringContext {
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContext.class)
public class TodoBusinessTest {

	@Autowired
	TodoBusinessService businessService;

	@Test
	public void testGetTodosAboutSpring() {
		List<String> todos = businessService
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(1, todos.size());
		assertEquals("Learn Spring", todos.get(0));
	}
}