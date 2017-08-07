package com.in28minutes.data.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.in28minutes.data.api.TodoDataService;
import com.in28minutes.domain.TodoItem;
import com.in28minutes.domain.TodoItemList;

@Repository
public class TodoDataServiceImpl implements TodoDataService {

	@PersistenceContext
	private EntityManager entityManager;

	public TodoItem getTodoById(final long id) {
		return entityManager.find(TodoItem.class, id);
	}

	public TodoItemList getTodoListByUser(final long userId) {
		TypedQuery<TodoItem> query = entityManager.createNamedQuery(
				"findTodosByUser", TodoItem.class);
		query.setParameter(1, userId);
		return new TodoItemList(query.getResultList());
	}

	public TodoItemList getTodoListByUserAndTitle(final long userId,
			final String title) {
		TypedQuery<TodoItem> query = entityManager.createNamedQuery(
				"findTodosByTitle", TodoItem.class);
		query.setParameter(1, userId);
		query.setParameter(2, "%" + title.toUpperCase() + "%");
		return new TodoItemList(query.getResultList());
	}

	public TodoItem update(TodoItem todoItem) {
		return entityManager.merge(todoItem);
	}

	public TodoItem create(final TodoItem todoItem) {
		entityManager.persist(todoItem);
		return todoItem;
	}

	public void remove(final TodoItem todoItem) {
		TodoItem t = entityManager.find(TodoItem.class, todoItem.getId());
		entityManager.remove(t);
	}

}
