package com.in28minutes.springmvc.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.domain.User;
import com.in28minutes.service.api.UserService;
import com.in28minutes.springmvc.web.util.SessionData;
import com.in28minutes.web.common.form.LoginForm;

@Controller
public class LoginController extends AbstractController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageProvider;

	@Autowired
	private SessionData sessionData;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView redirectToLoginPage() {

		if (sessionData.getUser() != null) {
			return new ModelAndView(REDIRECT_TO_VIEW_TODOS_CONTROLLER);
		}

		ModelAndView modelAndView = new ModelAndView(USER_LOGIN_PAGE);
		modelAndView.addObject("loginTabStyle", "active");
		modelAndView.addObject("loginForm", new LoginForm());
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid LoginForm loginForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView(USER_LOGIN_PAGE);
			modelAndView.addObject(ERROR_MESSAGE, messageProvider.getMessage(
					"login.form.incomplete.details", null,
					sessionData.getLocale()));
			return modelAndView;
		}

		if (!isValidUser(loginForm)) {
			ModelAndView modelAndView = new ModelAndView(USER_LOGIN_PAGE);
			modelAndView.addObject(ERROR_MESSAGE, messageProvider.getMessage(
					"login.form.invalid.credentials", null,
					sessionData.getLocale()));
			return modelAndView;
		}

		User user = userService.getUserByEmail(loginForm.getEmail());

		sessionData.setUser(user);

		return new ModelAndView(REDIRECT_TO_VIEW_TODOS_CONTROLLER);
	}

	private boolean isValidUser(LoginForm loginForm) {
		return userService.isValidUser(loginForm.getEmail(),
				loginForm.getPassword());
	}

	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		sessionData.setUser(null);
		session.invalidate();
		return REDIRECT_TO_LOGIN_CONTROLLER;
	}
}