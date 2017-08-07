package com.in28minutes.example.layering.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.layering.business.api.TodoBusinessService;
import com.in28minutes.example.layering.model.api.client.Todo;

@Configuration
@ComponentScan(basePackages = {
		"com.in28minutes.example.layering.business.impl",
		"com.in28minutes.example.layering.data.stub" })
class SpringTestContext {
}

// 1. We need to test using Spring
// 2. How do we tell Spring to use specific Configuration
// 3. How do autowire the TodoBusinessService
// 4. How do we auto wire TodoDataServiceStub
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestContext.class)
public class TodoBusinessServiceJavaStubTest {

	@Autowired
	TodoBusinessService businessService;

	@Test
	public void testGetTodosAboutSpring() {
		List<Todo> todos = businessService
				.retrieveTodosRelatedToSpring("Ranga");
		System.out.println(todos);
		assertEquals(2, todos.size());
	}
}