package com.in28minutes.example.layering.business.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.business.api.TodoBusinessService;

@Configuration
@ComponentScan(basePackages = { "com.in28minutes" })
class SpringContext {
}

@Component
public class Main {

	@Autowired
	private TodoBusinessService todoBusinessService;

	private void runBusinessService() {
		System.out.println(todoBusinessService
				.retrieveTodosRelatedToSpring("Ranga"));
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				SpringContext.class);
		Main p = context.getBean(Main.class);
		p.runBusinessService();
	}

}