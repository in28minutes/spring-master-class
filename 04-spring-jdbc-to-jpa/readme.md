##  Spring JDBC and JPA (Hibernate)

Let's play and learn more about Spring

- Step 1 : 
- Step 2 : 

## Connecting to My SQL and Other Databases

Spring Boot makes it easy to switch databases! Yeah really simple.

## Steps
- Install MySQL and Setup Schema
- Remove H2 dependency from pom.xml
- Add MySQL (or your database) dependency to pom.xml
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```
- Configure application.properties

```properties
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/person_example
spring.datasource.username=personuser
spring.datasource.password=YOUR_PASSWORD
```

- Restart the app and You are ready!

> Spring Boot can setup the database for you using Hibernate

Things to note:
- Spring Boot chooses a default value for you based on whether it thinks your database is embedded (default create-drop) or not (default none).
- ```spring.jpa.hibernate.ddl-auto``` is the setting to perform SchemaManagementTool actions automatically
   - none : No action will be performed.
   - create-only : Database creation will be generated.
   - drop : Database dropping will be generated.
   - create : Database dropping will be generated followed by database creation.
   - validate : Validate the database schema
   - update : Update the database schema
- Reference : https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#configurations-hbmddl


application.properties
```
#none, validate, update, create, create-drop
spring.jpa.hibernate.ddl-auto=create
```

## Installing and Setting Up MySQL

- Install MySQL https://dev.mysql.com/doc/en/installing.html
  - More details - http://www.mysqltutorial.org/install-mysql/
  - Trouble Shooting - https://dev.mysql.com/doc/refman/en/problems.html
- Startup the Server (as a service)
- Go to command prompt (or terminal)
   - Execute following commands to create a database and a user

```
mysql --user=user_name --password db_name
create database person_example;
create user 'personuser'@'localhost' identified by 'YOUR_PASSWORD';
grant all on person_example.* to 'personuser'@'localhost';
```

- Execute following sql queries to create the table and insert the data

Table

```sql
create table person
(
	id integer not null,
	birth_date timestamp,
	location varchar(255),
	name varchar(255),
	primary key (id)
);

```

Data

```sql
insert into person(id, birth_date,location, name) values(10001,sysdate(),'Hyderabad','Ravi');
insert into person(id, birth_date,location, name) values(10002,sysdate(),'Chicago','James');
insert into person(id, birth_date,location, name) values(10003,sysdate(),'Amsterdam','Pieter');
```
## Complete Code Example

TODO

## Notes

#### JdbcTemplate AutoConfiguration
```
=========================
AUTO-CONFIGURATION REPORT
=========================

DataSourceAutoConfiguration matched:
   - @ConditionalOnClass found required classes 'javax.sql.DataSource', 'org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)

DataSourceTransactionManagerAutoConfiguration matched:
   - @ConditionalOnClass found required classes 'org.springframework.jdbc.core.JdbcTemplate', 'org.springframework.transaction.PlatformTransactionManager'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)

H2ConsoleAutoConfiguration matched:
   - @ConditionalOnClass found required class 'org.h2.server.web.WebServlet'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
   - found ConfigurableWebEnvironment (OnWebApplicationCondition)
   - @ConditionalOnProperty (spring.h2.console.enabled=true) matched (OnPropertyCondition)

JdbcTemplateAutoConfiguration matched:
   - @ConditionalOnClass found required classes 'javax.sql.DataSource', 'org.springframework.jdbc.core.JdbcTemplate'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
   - @ConditionalOnSingleCandidate (types: javax.sql.DataSource; SearchStrategy: all) found a primary bean from beans 'dataSource' (OnBeanCondition)

JdbcTemplateAutoConfiguration.JdbcTemplateConfiguration#jdbcTemplate matched:
   - @ConditionalOnMissingBean (types: org.springframework.jdbc.core.JdbcOperations; SearchStrategy: all) did not find any beans (OnBeanCondition)

```