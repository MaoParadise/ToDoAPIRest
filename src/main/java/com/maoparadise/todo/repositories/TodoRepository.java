package com.maoparadise.todo.repositories;

import java.util.ArrayList;

import com.maoparadise.todo.models.TodoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoModel, Long> {
    //busca por description
    public abstract ArrayList<TodoModel> findByDescription(String description);
}
    
