package com.example.test1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/getFruits")
    public List<String> getVegetables() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Guava");
        fruits.add("Banana");
        fruits.add("Grapes");
        return fruits;
    }
}
