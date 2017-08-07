package com.in28minutes.data.api;

import com.in28minutes.domain.User;


public interface UserDataService {

	
	User getUserByEmail(final String email);

	
	boolean login(final String email, final String password);

	
	User create(final User user);

	
	User update(User user);

	
	void remove(final User user);

}
