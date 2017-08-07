package com.in28minutes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.data.api.UserDataService;
import com.in28minutes.domain.User;
import com.in28minutes.service.api.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDataService userDataService;

	
	public User create(final User user) {
		return userDataService.create(user);
	}

	
	public User update(User user) {
		return userDataService.update(user);
	}

	
	public void remove(final User user) {
		userDataService.remove(user);
	}

	
	@Transactional(readOnly = true)
	public User getUserByEmail(final String email) {
		return userDataService.getUserByEmail(email);
	}

	
	@Transactional(readOnly = true)
	public boolean isValidUser(final String email, final String password) {
		return userDataService.login(email, password);
	}
}
