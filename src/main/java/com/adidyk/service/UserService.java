package com.adidyk.service;

import com.adidyk.model.User;
import com.adidyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Class UserService.
 */
@Service
public class UserService {

    /**
     * @param repository - repository.
     */
    private final UserRepository repository;

    /**
     * UserService - constructor.
     * @param repository - repository.
     */
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * findByLogin - find by login.
     * @param user - user.
     * @return - returns user.
     */
    private User findByLogin(User user) {
        return this.repository.findByLogin(user.getLogin());
    }

    /**
     * save - save new user.
     * @param user - user.
     */
    public void save(User user) {
        User searchUser = this.findByLogin(user);
        System.out.println();
        System.out.println(searchUser);
        if (searchUser != null) {
            System.out.println("user with that username already exists");
        } else {
            System.out.println("new user added");
            this.repository.save(user);
        }
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param user - smart phone.
     */
    public User findByLoginAndPassword(User user) {
        return this.repository.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    /**
     *
     * @param user - user.
     * @return - return.
     */
    public User findById(User user) {
        return this.repository.findById(user.getId()).orElse(null);
    }

}