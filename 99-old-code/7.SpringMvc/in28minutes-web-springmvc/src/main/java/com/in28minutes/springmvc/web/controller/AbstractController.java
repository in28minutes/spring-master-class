package com.in28minutes.springmvc.web.controller;

import org.springframework.web.servlet.ModelAndView;

public class AbstractController {
	protected static final String ERROR_MESSAGE = "error";

	protected static final String REDIRECT_TO_VIEW_TODOS_CONTROLLER = "redirect:/user/todos";

	protected static final String USER_LOGIN_PAGE = "user/login";

	protected static final String ERROR_PAGE = "error";

	protected static final String REDIRECT_TO_LOGIN_CONTROLLER = "redirect:/login";

	protected ModelAndView redirectToErrorPageWithMessage(String errorMessage) {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		modelAndView.addObject(ERROR_MESSAGE, errorMessage);
		return modelAndView;
	}
}