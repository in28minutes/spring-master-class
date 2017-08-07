package com.in28minutes.spring.example1.database;

import java.util.List;

public class Database {
	public static List<String> retrieveTodos(String user) {
		throw new RuntimeException("Database Down");
		// return Arrays.asList("Learn Spring","Learn Struts","Learn to Dance");
	}
}