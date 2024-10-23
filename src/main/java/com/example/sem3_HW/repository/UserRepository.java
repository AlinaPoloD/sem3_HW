package com.example.sem3_HW.repository;

import com.example.sem3_HW.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private List<User> users = new ArrayList();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
