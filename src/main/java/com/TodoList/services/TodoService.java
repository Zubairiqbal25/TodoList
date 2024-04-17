package com.TodoList.services;

import com.TodoList.exceptions.TodoException;
import com.TodoList.models.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodos() throws TodoException;
    public Todo getTodoById(Integer id) throws TodoException;
    public Todo addTodo(Todo todo) throws TodoException;
    public Todo updateTodo(Integer id, Todo updatedTodo) throws TodoException;
    public boolean deleteTodo(Integer id) throws TodoException;
}
