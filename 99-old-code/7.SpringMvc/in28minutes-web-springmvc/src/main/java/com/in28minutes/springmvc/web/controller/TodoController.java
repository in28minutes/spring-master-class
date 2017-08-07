package com.in28minutes.springmvc.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.domain.Priority;
import com.in28minutes.domain.TodoItem;
import com.in28minutes.domain.TodoItemList;
import com.in28minutes.domain.User;
import com.in28minutes.service.api.TodoService;
import com.in28minutes.springmvc.web.util.SessionData;
import com.in28minutes.springmvc.web.util.TodoPriorityPropertyEditor;
import com.in28minutes.web.common.util.TodoListUtils;

@Controller
public class TodoController extends AbstractController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass()
			.getName());

	@Autowired
	private SessionData sessionData;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TodoService todoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				TodoListUtils.DATE_FORMAT);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
		binder.registerCustomEditor(Priority.class,
				new TodoPriorityPropertyEditor());
	}

	@RequestMapping("/user/todos")
	public ModelAndView loadTodoList() {

		ModelAndView modelAndView = new ModelAndView();

		// user login is ensured by the login filter/interceptor

		TodoItemList todoList = todoService.getTodoListByUser(sessionData
				.getUser().getId());

		modelAndView.addObject("todoList", todoList.getItems());

		modelAndView.addObject("totalCount", todoList.getCount());
		modelAndView.addObject("doneCount", todoList.getDoneCount());
		modelAndView.addObject("todoCount", todoList.getTodoCount());
		modelAndView.addObject("homeTabStyle", "active");

		modelAndView.setViewName("todo/list");
		return modelAndView;

	}

	@RequestMapping(value = "/user/todos/new", method = RequestMethod.GET)
	public String showCreateTodo(Model model) {
		model.addAttribute("today", new SimpleDateFormat(
				TodoListUtils.DATE_FORMAT).format(new Date()));
		model.addAttribute("todo", new TodoItem());
		return "todo/create";
	}

	@RequestMapping(value = "/user/todos/new", method = RequestMethod.POST)
	public String createNewTodo(@ModelAttribute TodoItem todoItem) {
		final User user = sessionData.getUser();
		todoItem.setDone(false);
		todoItem.setUserId(user.getId());
		todoService.create(todoItem);
		return REDIRECT_TO_VIEW_TODOS_CONTROLLER;
	}

	@RequestMapping("/user/todos/{todoId}/update")
	public String showUpdateTodo(@PathVariable long todoId, Model model) {
		LOGGER.info("Updating TODO");
		TodoItem todoItem = todoService.getTodoById(todoId);
		model.addAttribute("todo", todoItem);
		return "todo/update";
	}

	@RequestMapping(value = "/user/todos/update", method = RequestMethod.POST)
	public String updateTodo(@ModelAttribute TodoItem todoItem) {
		LOGGER.info("Updating TODO" + todoItem);
		todoService.update(todoItem);
		return REDIRECT_TO_VIEW_TODOS_CONTROLLER;
	}

	@RequestMapping(value = "/user/todos/{todoId}/delete", method = RequestMethod.POST)
	public ModelAndView deleteTodo(@PathVariable long todoId) {

		TodoItem todoItem = todoService.getTodoById(todoId);
		if (todoItem == null) {
			String errorMessage = messageSource.getMessage("no.such.todo",
					new Object[] { todoId }, sessionData.getLocale());
			return redirectToErrorPageWithMessage(errorMessage);
		}

		todoService.remove(todoItem);

		return new ModelAndView(REDIRECT_TO_VIEW_TODOS_CONTROLLER);

	}

	@RequestMapping(value = "/user/todos/search", method = RequestMethod.GET)
	public String searchTodo(@RequestParam String title, Model model) {
		TodoItemList todoList = todoService.searchTodoListByTitle(sessionData
				.getUser().getId(), title);
		model.addAttribute("todoList", todoList.getItems());
		model.addAttribute("title", title);
		return "todo/search";
	}

}