package com.in28minutes.spring.example1.businessservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.spring.example1.dataservice.api.TodoDataService;

@Component
public class TodoBusinessService {

	@Autowired
	TodoDataService dataService;// = new TodoDataServiceStub()

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> todosRelatedToSpring = new ArrayList<String>();

		List<String> todos = dataService.retrieveTodos(user);

		for (String todo : todos) {
			if (todo.contains("Spring")) {
				todosRelatedToSpring.add(todo);
			}
		}
		return todosRelatedToSpring;
	}

}
