package com.maoparadise.todo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.maoparadise.todo.models.TodoModel;
import com.maoparadise.todo.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public ArrayList<TodoModel> getTodos(){
        return (ArrayList<TodoModel>) todoRepository.findAll();
    }


    public TodoModel saveTodo(TodoModel todo){
        return todoRepository.save(todo);
    }


    public Optional<TodoModel> getTodo(Long id){
        return todoRepository.findById(id);
    }

    public ArrayList<TodoModel> findByDescription(String description){
        return todoRepository.findByDescription(description);
    }

    // para eliminar todos
    public boolean deleteTodo(Long id){
        try{
            todoRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
