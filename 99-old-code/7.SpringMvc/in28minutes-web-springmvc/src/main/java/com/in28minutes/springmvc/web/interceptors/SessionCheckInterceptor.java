package com.in28minutes.springmvc.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.in28minutes.springmvc.web.util.SessionData;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SessionData sessionData;

	@Override
	public boolean preHandle(final HttpServletRequest request,
			final HttpServletResponse response, final Object handler)
			throws Exception {
		if (sessionData.getUser() == null) {
			response.sendRedirect("/login");
			return false;
		} else {
			return true;
		}
	}
}
