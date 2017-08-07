package com.in28minutes.springmvc.services.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.in28minutes.springmvc.services.web.service.api.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	List<String> todos = new ArrayList<String>();

	@PostConstruct
	public void setupTodo() {
		todos.add("Write better code");
		todos.add("Learn AngularJs");
		todos.add("Watch star wars again!!!");
	}

	public List<String> allTodos() {
		return todos;
	}

	public void addTodo(String todo) {
		if (!todos.contains(todo)) {
			todos.add(todo);
		}
	}

	public void deleteTodo(String todo) {
		if (todos.contains(todo)) {
			todos.remove(todo);
		}
	}

	public void deleteAll() {
		todos.clear();
	}

	public void updateTodo(int position, String todo) {
		todos.set(position, todo);
	}
}
