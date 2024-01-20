package com.in28minutes.spring.basics.springin5steps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="/testContext.xml")
class SpringIn5StepsBasicApplicationTests {

	@Test
	void contextLoads() {
	}

}
