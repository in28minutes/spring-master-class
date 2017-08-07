package com.in28minutes.springmvc.services.web.service.api;

import java.util.List;

/**
 * Created by tmichels on 8/1/14.
 */
public interface TodoService {
    public List<String> allTodos();
    public void addTodo(String todo);
    public void deleteTodo(String todo);
    public void deleteAll();
    public void updateTodo(int position, String todo);
}
