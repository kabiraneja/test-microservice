package com.example.demo_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getVegetables")
    public List<String> getVegetables() {
        List<String> vege = new ArrayList<>();
        vege.add("Brinjal");
        vege.add("Potato");
        vege.add("Capsicum");
        return vege;
    }
    @GetMapping("/getFruits")
    public String getFruits() {

        String url = "http://3.111.51.62:9090/getFruits";
        return restTemplate.getForObject(url, String.class);

    }

    @GetMapping("/getEmployees")
    public List getEmployees() {

        List emp = new ArrayList();
        emp.add("Piyush");
        emp.add("Mayank");
        emp.add("Rahul");

        return emp;

    }
}
