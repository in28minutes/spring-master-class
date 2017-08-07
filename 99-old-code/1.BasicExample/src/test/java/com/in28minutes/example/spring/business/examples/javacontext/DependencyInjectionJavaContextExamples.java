package com.in28minutes.example.spring.business.examples.javacontext;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.spring.business.examples.HiService;

//Top Spring Annotations
//Component/Service, Autowired, Configuration, ComponentScan
//RunWith, ContextConfiguration

@Configuration
@ComponentScan(basePackages = "com.in28minutes.example.spring.business.examples")
class JavaTestContext {

}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaTestContext.class)
public class DependencyInjectionJavaContextExamples {

	@Autowired
	private HiService service;

	@Test
	public void dummyTest() {
		assertEquals("Good Morning", service.sayHi());
	}
}
