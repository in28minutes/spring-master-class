package com.in28minutes.domain;

import java.io.Serializable;
import java.util.List;

public class TodoItemList implements Serializable {
	private static final long serialVersionUID = -8792771542053075160L;
	private List<TodoItem> items;

	public TodoItemList(List<TodoItem> items) {
		super();
		this.items = items;
	}

	public List<TodoItem> getItems() {
		return items;
	}

	public int getDoneCount() {
		int count = 0;
		for (TodoItem todoItem : items) {
			if (todoItem.isDone()) {
				count++;
			}
		}
		return count;
	}

	public int getTodoCount() {
		return getCount() - getDoneCount();
	}

	public int getCount() {
		return items.size();
	}

	@Override
	public String toString() {
		return String.format("TodoItemList [items=%s]", items);
	}
}
