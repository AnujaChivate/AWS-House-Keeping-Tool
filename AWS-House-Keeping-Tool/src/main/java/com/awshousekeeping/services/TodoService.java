package com.awshousekeeping.services;

import java.util.List;

import com.awshousekeeping.model.Todo;

public interface TodoService {
	public List<Todo> retrieveTodos();

	public void addTodo(Todo todo);

	public void deleteTodo(Todo todo);
}
