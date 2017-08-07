package com.in28minutes.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.domain.TodoItem;
import com.in28minutes.service.api.TodoService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/service-context.xml" })
public class TodoServiceTest {

	@Autowired
	private TodoService todoService;

	@Test
	public void testGetTodoById() {
		TodoItem todoItem = todoService.getTodoById(1);
		assertNotNull(todoItem);
		assertEquals(1, todoItem.getId());
	}

}