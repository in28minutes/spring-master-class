package com.in28minutes.springmvc.services.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springmvc.services.web.service.api.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "/all.json")
	public @ResponseBody List<String> viewAllTodos() {
		return todoService.allTodos();
	}

	@RequestMapping(value = "/add/{todo}", method = RequestMethod.POST)
	public @ResponseBody void addTodo(@PathVariable("todo") String todo) {
		todoService.addTodo(todo);
	}

	@RequestMapping(value = "/delete/{todo}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteTodo(@PathVariable("todo") String todo) {
		todoService.deleteTodo(todo);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAllTodo() {
		todoService.deleteAll();
	}

	@RequestMapping(value = "/update/{position}/{todo}", method = RequestMethod.PUT)
	public @ResponseBody void updateTodo(
			@PathVariable("position") String position,
			@PathVariable("todo") String todo) {
		todoService.updateTodo(Integer.valueOf(position), todo);
	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return "todo/layout";
	}
}
