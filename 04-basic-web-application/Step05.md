\pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.in28minutes</groupId>
	<artifactId>in28Minutes-first-webapp</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>

	<dependencies>
		<dependency>
			<groupId>javax</groupId>
			<artifactId>javaee-web-api</artifactId>
			<version>6.0</version>
			<scope>provided</scope>
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
\src\main\java\webapp\LoginServlet.java
```
package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}
```
\\src\main\webapp\WEB-INF\views\login.jsp
```
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<form action="/login.do" method="POST">
		Name : <input type="text" /> <input type="submit" />
	</form>
</body>
</html>
```
\src\main\webapp\WEB-INF\views\welcome.jsp
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
\src\main\webapp\WEB-INF\web.xml
```
<!-- webapp/WEB-INF/web.xml -->
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
	version="3.0">

	<display-name>To do List</display-name>

	<welcome-file-list>
		<welcome-file>login.do</welcome-file>
	</welcome-file-list>

</web-app>
```
