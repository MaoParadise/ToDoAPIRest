package com.maoparadise.todo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.maoparadise.todo.models.TodoModel;
import com.maoparadise.todo.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping()
    public ArrayList<TodoModel> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping()
    public TodoModel saveTodo(@RequestBody TodoModel todo) {
        return todoService.saveTodo(todo);
    }

    // el path implica que el id es un parametro directo en la url y no una variable y debe user PathVariable
    @GetMapping( path = "/{id}")
    public Optional<TodoModel> getTodo(@PathVariable("id") Long id) {
        return todoService.getTodo(id);
    }

    // si el getMapping no lleva path, el parametro es una variable y se debe usar el RequestParam
    @GetMapping("/description")
    public ArrayList<TodoModel> findByDescription(@RequestParam("description") String description) {
        return todoService.findByDescription(description);
    }
    
    // el path implica que el id es un parametro directo en la url y no una variable y debe user PathVariable
    @DeleteMapping(path = "/{id}")
    public boolean deleteTodo(@PathVariable("id") Long id) {
        boolean result = todoService.deleteTodo(id);
        if(result) {
            return "Todo deleted successfully".equals("Todo deleted successfully");
        } else {
            return "Todo not found".equals("Todo not found");
        }
    }
    
}
