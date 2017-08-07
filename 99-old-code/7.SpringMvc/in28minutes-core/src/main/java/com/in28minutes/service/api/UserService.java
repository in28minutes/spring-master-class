package com.in28minutes.service.api;

import com.in28minutes.domain.User;


public interface UserService {

	
	User getUserByEmail(final String email);

	
	boolean isValidUser(final String email, final String password);

	
	User create(final User user);

	
	User update(User user);

	
	void remove(final User user);
}
