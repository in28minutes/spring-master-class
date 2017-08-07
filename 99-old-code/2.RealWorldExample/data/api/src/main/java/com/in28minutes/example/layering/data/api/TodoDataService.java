package com.in28minutes.example.layering.data.api;

import java.util.List;

import com.in28minutes.example.layering.model.api.client.Todo;

public interface TodoDataService {
	List<Todo> retrieveTodos(String userName);
}
