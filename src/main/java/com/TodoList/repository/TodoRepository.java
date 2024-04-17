package com.TodoList.repository;

import com.TodoList.models.Todo;

import java.util.List;

public interface TodoRepository {

    public List<Todo> findAll();
    public Todo findById(Integer id);
    public Todo save(Todo todo);
    public Todo update(Integer id,Todo todo);
    public Boolean delete(Integer id);
}
