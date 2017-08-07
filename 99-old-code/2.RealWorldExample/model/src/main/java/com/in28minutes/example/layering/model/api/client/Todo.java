package com.in28minutes.example.layering.model.api.client;

import java.util.Date;

public class Todo {

	private String desc;
	private Date date;
	private boolean isDone;

	public Todo(String desc, Date date, boolean isDone) {
		super();
		this.desc = desc;
		this.date = date;
		this.isDone = isDone;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return String.format("Todo [desc=%s, date=%s, isDone=%s]", desc, date,
				isDone);
	}

}
