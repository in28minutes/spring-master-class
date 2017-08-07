package com.in28minutes.example.spring.dataservice.stub;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.example.spring.data.api.TodoDataService;
import com.in28minutes.example.spring.model.Todo;

@Component
public class TodoDataServiceDummyImpl implements TodoDataService {
	private static final int ONE_DAY_IN_MILLISECONDS = 24 * 60 * 1000;

	public List<Todo> retrieveTodos(String userName) {

		Date today = new Date();
		long todayMs = today.getTime();

		Date tomorrow = new Date(todayMs + ONE_DAY_IN_MILLISECONDS);
		Date tenDaysAfter = new Date(todayMs + 10 * ONE_DAY_IN_MILLISECONDS);

		List<Todo> todos = Arrays.asList(new Todo("Complete Spring Tutorial",
				today, false), new Todo("Complete Spring MVC Tutorial",
				tomorrow, false), new Todo("Complete All Tutorials",
				tenDaysAfter, false));

		return todos;
	}
}
