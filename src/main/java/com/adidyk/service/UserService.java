package com.adidyk.service;

import com.adidyk.model.User;
import com.adidyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        this.repository.save(user);
    }

    public User findById(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

}
