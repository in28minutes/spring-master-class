package com.in28minutes.jdbc.data.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.in28minutes.jdbc.hsql.HsqlDatabase;
import com.in28minutes.jdbc.model.Todo;

class TodoMapper implements RowMapper<Todo> {
	public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Todo todo = new Todo();
		todo.setId(rs.getInt(1));
		todo.setDescription(rs.getString(2));
		todo.setDone(rs.getBoolean(3));
		return todo;
	}
}

public class TodoDataServiceSpringJdbc {

	private static final String SELECT_ALL_TODOS = "SELECT * FROM TODO";

	private static final String INSERT_TODO_QUERY = "INSERT INTO TODO(DESCRIPTION,IS_DONE) VALUES(?, ?)";

	private static final String DELETE_TODO_QUERY = "DELETE FROM TODO WHERE ID=?";

	HsqlDatabase db = new HsqlDatabase();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(
			new SingleConnectionDataSource(db.conn, false));

	public static Logger logger = LogManager
			.getLogger(TodoDataServiceSpringJdbc.class);

	public void insertTodos(List<Todo> todos) {
		for (Todo todo : todos) {
			insertTodo(todo);
		}
	}

	private void insertTodo(Todo bean) {
		jdbcTemplate.update(INSERT_TODO_QUERY, bean.getDescription(),
				bean.isDone());
	}

	public void deleteTodo(int id) {
		jdbcTemplate.update(DELETE_TODO_QUERY, id);
	}

	public List<Todo> retrieveAllTodos() throws SQLException {
		return jdbcTemplate.query(SELECT_ALL_TODOS, new TodoMapper());
	}

	/*
	 * com.in28minutes.jdbc.data.service.TodoDataServiceSpringJdbc [Todo [id=0,
	 * description=Spring Tutorial, isDone=false], Todo [id=2,
	 * description=Struts Tutorials, isDone=false], Todo [id=3, description=Make
	 * a List, isDone=false], Todo [id=23, description=New Todo Spring JDBC,
	 * isDone=false], Todo [id=24, description=New Todo Spring JDBC,
	 * isDone=false], Todo [id=25, description=New Todo Spring JDBC,
	 * isDone=false], Todo [id=26, description=New Todo fasdf1, isDone=false],
	 * Todo [id=27, description=New Todo Spring JDBC, isDone=false]]
	 */

	/*
	 * class TodoMapper implements RowMapper<Todo> { public Todo
	 * mapRow(ResultSet rs, int rowNum) { Todo todo = new Todo(); return todo; }
	 * }
	 */

	public static void main(String[] args) throws SQLException {

		TodoDataServiceSpringJdbc dataservice = new TodoDataServiceSpringJdbc();

		dataservice.insertTodos(Arrays.asList(new Todo(0,
				"New Todo Spring JDBC", false)));

		dataservice.deleteTodo(1);

		List<Todo> todos = dataservice.retrieveAllTodos();
		logger.info(todos);

		dataservice.db.closeConnection();
	}
}