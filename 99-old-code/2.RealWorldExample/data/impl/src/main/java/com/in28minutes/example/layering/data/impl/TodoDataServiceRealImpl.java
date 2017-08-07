package com.in28minutes.example.layering.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.data.api.TodoDataService;
import com.in28minutes.example.layering.data.database.Database;
import com.in28minutes.example.layering.model.api.client.Todo;

@Component
public class TodoDataServiceRealImpl implements TodoDataService {

	@Autowired
	private Database database;

	@Override
	public List<Todo> retrieveTodos(String userName) {
		return database.retrieveTodos(userName);
	}
}
