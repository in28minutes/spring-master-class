package com.in28minutes.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "findTodosByUser", query = "SELECT t FROM TodoItem t where t.userId = ?1 order by t.dueDate"),
		@NamedQuery(name = "findTodosByTitle", query = "SELECT t FROM TodoItem t where t.userId = ?1 and upper(t.title) like ?2 order by t.dueDate") })
public class TodoItem implements Serializable {

	private static final long serialVersionUID = 2286464606540817270L;

	@Id
	@GeneratedValue
	private long id;

	private long userId;

	@Column(length = 512)
	private String title;

	private boolean done;

	@Enumerated(value = EnumType.ORDINAL)
	private Priority priority;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	public TodoItem() {
		priority = Priority.LOW;
	}

	public TodoItem(long userId, String title, boolean done, Priority priority,
			Date dueDate) {
		this.userId = userId;
		this.title = title;
		this.done = done;
		this.priority = priority;
		this.dueDate = dueDate;
	}

	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return String
				.format("TodoItem [id=%s, userId=%s, user=%s, title=%s, done=%s, priority=%s, dueDate=%s]",
						id, userId, "", title, done, priority, dueDate);
	}

	public void setId(long id) {
		this.id = id;
	}
}
