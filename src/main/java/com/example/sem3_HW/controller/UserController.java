package com.example.sem3_HW.controller;

import com.example.sem3_HW.domain.User;
import com.example.sem3_HW.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private RegistrationService service;

@GetMapping
    public List<User> userList() {
    return service.getDataProcessingServise().getRepository().getUsers();

}
@PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
{
    service.getDataProcessingServise().getRepository().getUsers().add(user);
    return "User added from body";

}

}
