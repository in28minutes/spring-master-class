package com.in28minutes.example.spring.data.api;

import java.util.List;

import com.in28minutes.example.spring.model.Todo;

public interface TodoDataService {
	List<Todo> retrieveTodos(String userName);
}
