package com.example.sem3_HW.services;

import com.example.sem3_HW.domain.User;
import com.example.sem3_HW.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingServise {
    @Autowired
    private UserRepository repository;
    public List<User> sortUserByAge(List<User> users) {
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());


    }

    public List<User> filterUserByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());

    }
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);



    }


    public void addUserToList(User user) {

        repository.getUsers().add(user);
    }

    public UserRepository getRepository() {
        return repository;
    }
}
