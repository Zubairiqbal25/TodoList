package com.TodoList.services;

import com.TodoList.exceptions.TodoException;
import com.TodoList.models.Todo;
import com.TodoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) throws TodoException {
        this.todoRepository = todoRepository;
    }
    @Override
    public List<Todo> getAllTodos() throws TodoException {
        return todoRepository.findAll();
//        if(opt !=  null)
//        {
//            return opt;
//        }
//
//        throw new TodoException("No Item Available to Show");
    }

    @Override
    public Todo getTodoById(Integer id) throws TodoException{
        return todoRepository.findById(id); //.orElse(null)
    }

    @Override
    public Todo addTodo(Todo todo) throws TodoException {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Integer id, Todo updatedTodo) throws TodoException{
        // Implement update logic using repository
        return todoRepository.update(id,updatedTodo);
    }

    @Override
    public boolean deleteTodo(Integer id) throws TodoException{
        // Implement delete logic using repository
        return todoRepository.delete(id);
    }

}
