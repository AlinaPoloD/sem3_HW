package com.example.sem3_HW.controller;

import com.example.sem3_HW.domain.User;
import com.example.sem3_HW.services.DataProcessingServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")


public class TaskController {
    @Autowired
   private DataProcessingServise dataProcessingServise;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {

        return dataProcessingServise.sortUserByAge(dataProcessingServise.getRepository().getUsers());

    }
    @GetMapping("/filter/{age}")
    public List<User> filterByAge(@PathVariable("age") int age) {

        return dataProcessingServise.filterUserByAge(dataProcessingServise.getRepository().getUsers(),age);

    }
    @GetMapping("/calculateAverageAge")
    public double calculateAverageAge() {

        return dataProcessingServise.calculateAverageAge(dataProcessingServise.getRepository().getUsers());

    }



}
