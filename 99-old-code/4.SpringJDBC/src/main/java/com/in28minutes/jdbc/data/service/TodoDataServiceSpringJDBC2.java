package com.in28minutes.jdbc.data.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.in28minutes.jdbc.hsql.HsqlDatabase;
import com.in28minutes.jdbc.model.Todo;

public class TodoDataServiceSpringJDBC2 {

	private static final String INSERT_TODO_QUERY = "INSERT INTO TODO(DESCRIPTION,IS_DONE) VALUES(?, ?)";

	private static final String DELETE_TODO_QUERY = "DELETE FROM TODO WHERE ID=?";

	HsqlDatabase db = new HsqlDatabase();

	JdbcTemplate jdbcTemplate = new JdbcTemplate(
			new SingleConnectionDataSource(db.conn, false));

	public static Logger logger = LogManager
			.getLogger(TodoDataServiceSpringJDBC2.class);

	public void insertTodos(List<Todo> todos) {
		for (Todo todo : todos) {
			insertTodo(todo);
		}
	}

	private void insertTodo(Todo todo) {
		jdbcTemplate.update(INSERT_TODO_QUERY, todo.getDescription(),
				todo.isDone());
	}

	public void deleteTodo(int id) {
		jdbcTemplate.update(DELETE_TODO_QUERY, id);
	}

	public List<Todo> retrieveAllTodos() throws SQLException {
		jdbcTemplate.query("SELECT * FROM TODO",
				new BeanPropertyRowMapper<Todo>(Todo.class));

		List<Todo> todos = new ArrayList<Todo>();
		Statement st = db.conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM TODO");
		while (rs.next()) {
			todos.add(new Todo(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
		}
		st.close();
		return todos;
	}

	public static void main(String[] args) throws SQLException {

		TodoDataServiceSpringJDBC2 dataservice = new TodoDataServiceSpringJDBC2();

		dataservice.insertTodos(Arrays.asList(new Todo(0, "New Todo fasdf1",
				false)));
		dataservice.deleteTodo(1);
		List<Todo> todos = dataservice.retrieveAllTodos();
		logger.info(todos);
		dataservice.db.closeConnection();
	}
}
