package com.example.demo.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestResources {

    @GetMapping("resources/{name}")
    public String getName(@PathVariable String name){ return "Hello " + name;}
}
