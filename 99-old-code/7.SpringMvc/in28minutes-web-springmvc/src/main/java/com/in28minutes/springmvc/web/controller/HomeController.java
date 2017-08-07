package com.in28minutes.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends AbstractController {

	@RequestMapping(value = { "/index", "/" })
	public String redirectToIndexPage() {
		return REDIRECT_TO_LOGIN_CONTROLLER;
	}

	@RequestMapping("/learn-more")
	public ModelAndView redirectToAboutPage() {
		ModelAndView modelAndView = new ModelAndView("learnmore");
		modelAndView.addObject("aboutTabStyle", "active");
		return modelAndView;
	}
}
