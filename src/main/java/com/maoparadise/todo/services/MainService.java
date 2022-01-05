package com.maoparadise.todo.services;

import com.github.cliftonlabs.json_simple.JsonObject;

import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    public String getHello() {
        JsonObject json = new JsonObject();
        json.put("Message", "{ 'Hello' : 'World' }");
        
        return json.toJson();
    }

}
