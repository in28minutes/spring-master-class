package com.in28minutes.example.spring.business.api;

import java.util.List;

import com.in28minutes.example.spring.model.Todo;

public interface TodoBusinessService {
	List<Todo> retrieveTodosForNextWeek(String user);
}
