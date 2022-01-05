package com.maoparadise.todo.controllers;

import com.maoparadise.todo.services.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    MainService mainService;
    
    @GetMapping()
    public String getHello() {
        return mainService.getHello();
    }

}
