## Redirect to Login JSP
- View Resolver in todo-servlet.xml
- Update LoginController
- Remove @ResponseBody
- More about View Resolver

## Snippets

```
  <bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix">
            <value>/WEB-INF/views/</value>
        </property>
        <property name="suffix">
            <value>.jsp</value>
        </property>
    </bean>
```

## Files List
### /pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.in28minutes</groupId>
	<artifactId>in28Minutes-springmvc</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>

	<dependencies>
		<dependency>
			<groupId>javax</groupId>
			<artifactId>javaee-web-api</artifactId>
			<version>6.0</version>
			<scope>provided</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.2.2.RELEASE</version>
		</dependency>
	</dependencies>

	<build>
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.2</version>
					<configuration>
						<verbose>true</verbose>
						<source>1.8</source>
						<target>1.8</target>
						<showWarnings>true</showWarnings>
					</configuration>
				</plugin>
				<plugin>
					<groupId>org.apache.tomcat.maven</groupId>
					<artifactId>tomcat7-maven-plugin</artifactId>
					<version>2.2</version>
					<configuration>
						<path>/</path>
						<contextReloadable>true</contextReloadable>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
	</build>
</project>
```
### /src/main/java/com/in28minutes/jee/LoginService.java
```
package com.in28minutes.jee;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("in28Minutes") && password.equals("dummy");
	}

}
```
### /src/main/java/com/in28minutes/jee/LoginServlet.java
```
package com.in28minutes.jee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private LoginService service = new LoginService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isValidUser = service.validateUser(name, password);

		if (isValidUser) {
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(
					request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);
		}
	}

}
```
### /src/main/java/com/in28minutes/springmvc/login/LoginController.java
```
package com.in28minutes.springmvc.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
}
```
### /src/main/webapp/WEB-INF/todo-servlet.xml
```
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.in28minutes" />

    <mvc:annotation-driven />
    
    <bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix">
            <value>/WEB-INF/views/</value>
        </property>
        <property name="suffix">
            <value>.jsp</value>
        </property>
    </bean>
    
</beans>
```
### /src/main/webapp/WEB-INF/views/login.jsp
```
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/login.do" method="POST">
        Name : <input name="name" type="text" /> Password : <input name="password" type="password" /> <input type="submit" />
    </form>
</body>
</html>
```
### /src/main/webapp/WEB-INF/views/welcome.jsp
```
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
Welcome ${name}
</body>
</html>
```
### /src/main/webapp/WEB-INF/web.xml
```
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    version="3.0">

    <display-name>To do List</display-name>

    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/todo-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/spring-mvc/*</url-pattern>
    </servlet-mapping>
</web-app>
```
