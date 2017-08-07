package com.in28minutes.example.layering.data.database;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.model.api.client.Todo;

//TODO : Ideally should use jdbc interfacing or an ORM
// A Dummy database just to quickly work something out

@Component
public class Database {
	public List<Todo> retrieveTodos(String userName) {

		List<Todo> todos = Arrays.asList(new Todo(
				"Real Database - Complete Spring Tutorial", new Date(), false),
				new Todo("Real Database - Complete Spring MVC Tutorial",
						new Date(), false), new Todo(
						"Real Database - Complete All Tutorials", new Date(),
						false));

		return todos;
	}

}
