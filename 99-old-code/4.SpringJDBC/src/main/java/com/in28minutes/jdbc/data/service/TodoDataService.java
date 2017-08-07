package com.in28minutes.jdbc.data.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.in28minutes.jdbc.hsql.HsqlDatabase;
import com.in28minutes.jdbc.model.Todo;

public class TodoDataService {

	private static final String INSERT_TODO_QUERY = "INSERT INTO TODO(DESCRIPTION,IS_DONE) VALUES(?, ?)";

	private static final String DELETE_TODO_QUERY = "DELETE FROM TODO WHERE ID=?";

	HsqlDatabase db = new HsqlDatabase();

	public static Logger logger = LogManager.getLogger(TodoDataService.class);

	public void insertTodos(List<Todo> todos) {
		for (Todo todo : todos) {
			insertTodo(todo);
		}
	}

	private void insertTodo(Todo todo) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(INSERT_TODO_QUERY);
			st.setString(1, todo.getDescription());
			st.setBoolean(2, todo.isDone());
			st.execute();
		} catch (SQLException e) {
			logger.fatal("Query Failed : " + INSERT_TODO_QUERY, e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// Ignore - nothing we can do..
				}
			}
		}
	}

	public void deleteTodo(int id) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(DELETE_TODO_QUERY);
			st.setInt(1, id);
			st.execute();
		} catch (SQLException e) {
			logger.fatal("Query Failed : " + DELETE_TODO_QUERY, e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// Ignore - nothing we can do..
				}
			}
		}
	}

	public List<Todo> retrieveAllTodos() throws SQLException {
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

		TodoDataService dataservice = new TodoDataService();

		dataservice.insertTodos(Arrays.asList(new Todo(0, "New Todo fasdf1",
				false)));
		dataservice.deleteTodo(1);
		List<Todo> todos = dataservice.retrieveAllTodos();
		logger.info(todos);
		dataservice.db.closeConnection();
	}
}
