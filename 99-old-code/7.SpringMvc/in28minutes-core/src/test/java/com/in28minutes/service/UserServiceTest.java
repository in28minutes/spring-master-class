package com.in28minutes.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.service.api.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/service-context.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testLogin_withGoodUser() {
		assertTrue(userService.isValidUser("user@in28minutes.com", "password"));
	}

	@Test
	public void testLogin_withBrokenUser() {
		assertFalse(userService.isValidUser("non-existing-user@dummy.com", "dummy"));
	}

}
