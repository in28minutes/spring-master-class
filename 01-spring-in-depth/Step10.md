
## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.spring.basics</groupId>
	<artifactId>spring-in-5-steps</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-in-5-steps</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.0.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/BinarySearchImpl.java

```java
package com.in28minutes.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		// Search the array
		return 3;
	}

}
```

### /src/main/java/com/in28minutes/spring/basics/springin5steps/BubbleSortAlgorithm.java

```java
package com.in28minutes.spring.basics.springin5steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/QuickSortAlgorithm.java

```java
package com.in28minutes.spring.basics.springin5steps;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Quick Sort
		return numbers;
	}
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SortAlgorithm.java

```java
package com.in28minutes.spring.basics.springin5steps;

public interface SortAlgorithm {
	public int[] sort(int[] numbers);
}
```
---

### /src/main/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsApplication.java

```java
package com.in28minutes.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	// What are the beans?
	// What are the dependencies of a bean?
	// Where to search for beans? => No need

	public static void main(String[] args) {

		// BinarySearchImpl binarySearch =
		// new BinarySearchImpl(new QuickSortAlgorithm());
		// Application Context
		ApplicationContext applicationContext = 
				SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearch = 
				applicationContext.getBean(BinarySearchImpl.class);
		int result = 
				binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.out.println(result);
	}
}
```
---

### /src/main/resources/application.properties

```properties
logging.level.org.springframework = debug
```
---

### /src/main/resources/log.txt

```
Searching directory [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps] for files matching pattern [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps/**/*.class]
Identified candidate component class: file [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps/BinarySearchImpl.class]
Identified candidate component class: file [/in28Minutes/git/getting-started-in-5-steps/spring-in-5-steps/target/classes/com/in28minutes/spring/basics/springin5steps/BubbleSortAlgorithm.class]

Creating instance of bean 'binarySearchImpl'
Creating instance of bean 'bubbleSortAlgorithm'
Finished creating instance of bean 'bubbleSortAlgorithm'

Constuctor - Autowiring by type from bean name 'binarySearchImpl' via constructor 
to bean named 'bubbleSortAlgorithm'
Setter -  Autowiring by type from bean name 'binarySearchImpl' to bean named 'bubbleSortAlgorithm'
No Setter or Constructor - Autowiring by type from bean name 'binarySearchImpl' to bean named 'bubbleSortAlgorithm'


Finished creating instance of bean 'binarySearchImpl'
```
---

### /src/test/java/com/in28minutes/spring/basics/springin5steps/SpringIn5StepsApplicationTests.java

```java
package com.in28minutes.spring.basics.springin5steps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringIn5StepsBasicApplicationTests {

    @Test
    public void contextLoads() {
    }

}
```
---


##### Ponints to be Learned Here 
```
1. public class BinarySearchImpl {

	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public BinarySearchImpl(SortAlgorithm sortAlgo){
	    this.sortAlgorithm = sortAlgo;
	    }
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		// Search the array
		return 3;
	}

  }
  If we do create constructor for depedency injection than it is called as constructor injection . 
 
2. How does @Component and @Autowire Work ? 
Ans.
Case 1: We have BinarySearchImpl class and BubbleSortAlgorithm class only : 
Sol : 
	1. Spring will run component scan , it will get BinarySearchImpl as component , then it will see 	it has some dependency , so it will not creates it bean initially . 
	2. It will then see BubbleSortAlgorithm component and since it has no dependency , it will create its bean .
	3. Now it will see bubblesort is the dependency for BinarySearchImpl , it will injects the dependency and create the bean for the same using constructor . 
Case 2: We have BinarySearchImpl class ,and 2 sort Algorithms BubbleSort and QuickSort. 
Sol :
	1. Assume @Primary annotation is not present . In this case , spring will create the bean for BubbleSort and QuickSort , but it will fail to create the bean for BinarySearchImpl , since it doesn't know which algo to use for dependency injection . Finally , error will come. 
	2. @Primary annotation can be used to resolve this conflict . It will tell spring to use that particular algo by default . 

3. What if we remove @Component from BubbleSort and QuickSort ? 
Sol: Spring will try to find dependency for BinarySearchImpl , which it will not get and hence error will come.
```
