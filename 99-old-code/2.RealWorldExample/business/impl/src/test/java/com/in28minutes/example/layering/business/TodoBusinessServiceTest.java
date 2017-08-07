package com.in28minutes.example.layering.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

//Application Context - java
//Business Impl - com.in28minutes.example.layering.business.impl
//Stub - com.in28minutes.example.layering.data.stub

@Configuration
@ComponentScan(basePackages = {
		"com.in28minutes.example.layering.business.impl",
		"com.in28minutes.example.layering.data.stub" })
class SpringApplicationContextTest {

}

// Spring
@RunWith(SpringJUnit4ClassRunner.class)
// Application Context
@ContextConfiguration(classes = SpringApplicationContextTest.class)
public class TodoBusinessServiceTest {

	@Autowired
	TodoBusinessService businessService;

	@Test
	public void testRetrieveTodosRelatedToSpring() {
		List<Todo> todos = businessService
				.retrieveTodosRelatedToSpring("Ranga");
		System.out.println(todos);
		assertEquals(2, todos.size());
	}

	@Test
	public void testTodoBusinessServiceIsProperlyLoaded() {
		assertNotNull(businessService);
	}

}
