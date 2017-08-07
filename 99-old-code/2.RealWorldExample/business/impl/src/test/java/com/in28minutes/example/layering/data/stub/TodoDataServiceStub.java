package com.in28minutes.example.layering.data.stub;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.data.api.TodoDataService;
import com.in28minutes.example.layering.model.api.client.Todo;

@Component
public class TodoDataServiceStub implements TodoDataService {

	@Override
	public List<Todo> retrieveTodos(String userName) {

		List<Todo> todos = Arrays.asList(new Todo(
				"Stub - Complete Spring Tutorial", new Date(), false),
				new Todo("Stub - Complete Spring MVC Tutorial", new Date(),
						false), new Todo("Stub - Complete All Tutorials",
						new Date(), false));

		return todos;
	}
}
