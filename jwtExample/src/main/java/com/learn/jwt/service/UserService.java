package com.learn.jwt.service;

import com.learn.jwt.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"ABC", "abc@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"XYZ", "XYZ@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"IJK", "IJK@gmail.com"));
    }

    public List<User> getUser(){
        return this.store;
    }


}
