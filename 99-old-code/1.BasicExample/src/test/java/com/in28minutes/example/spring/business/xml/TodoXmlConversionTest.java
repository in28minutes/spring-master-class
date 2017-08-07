package com.in28minutes.example.spring.business.xml;

import static org.junit.Assert.assertNotNull;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.spring.model.Todo;

@Configuration
@ComponentScan(basePackages = { "com.in28minutes.example.spring.business.xml" })
class SpringXmlContext {
	@Bean
	public Marshaller marshaller() {
		return new CastorMarshaller();
	}

	@Bean
	public Marshaller unmarshaller() {
		CastorMarshaller castorMarshaller = new CastorMarshaller();
		castorMarshaller.setTargetClass(Todo.class);
		return castorMarshaller;
	}
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringXmlContext.class)
public class TodoXmlConversionTest {

	/*
	 * <bean id="castorMarshaller"
	 * class="org.springframework.oxm.castor.CastorMarshaller" />
	 */
	@Autowired
	private Marshaller marshaller;

	@Autowired
	private Unmarshaller unmarshaller;

	@Test
	public void testXMLMarshalling() throws XmlMappingException, IOException {
		OutputStream outputStream = new FileOutputStream("./output.xml");
		Todo todo = new Todo("Complete Spring Tutorial - Current", new Date(),
				false);
		marshaller.marshal(todo, new StreamResult(outputStream));
		outputStream.close();
	}

	@Test
	public void testXMLUnMarshalling() throws XmlMappingException, IOException {
		InputStream inputStream = ClassLoader
				.getSystemResourceAsStream("input.xml");
		Todo todo = (Todo) unmarshaller
				.unmarshal(new StreamSource(inputStream));
		System.out.println(todo);
		inputStream.close();
		assertNotNull(todo);
		/*
		 * Todo [desc=Complete Spring Tutorial Example 1, date=Mon Nov 16
		 * 09:36:18 IST 2015, isDone=true]
		 */
	}

}