package com.adidyk.restful;

import com.adidyk.models.User;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class UserService.
 */
@RestController
public class UserService {

    /**
     * @param list - list user.
     */
    private static List<User> list = new ArrayList<>();

    static {
        User bob = new User(1, "bob", "white");
        User amanda = new User(2, "amanda", "red");
        User barbara = new User(3, "barbara", "black");
        list.add(bob);
        list.add(amanda);
        list.add(barbara);
    }

    /**
     * getAllUser - returns all users.
     * @return - returns all users.
     */
    @RequestMapping(value = "/get_users", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return list;
    }

    /**
     * getAllUser - returns all users.
     * @return - returns all users.
     */
    @RequestMapping(value = "/get_users_response", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUserResponse() {
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * getUser - gets first user.
     * @return - gets first user.
     */
    @RequestMapping(value = "/get_user", method = RequestMethod.GET)
    public User getUser() {
        return new User(4, "TEEEEEEEEEtest", "teFDFASDFSDFt");
    }

    /**
     * addUser - adds user.
     * @param user - user.
     */
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        System.out.println(user);
        list.add(user);
        System.out.println(list);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "add_all_user", method = RequestMethod.POST)
    public ResponseEntity<List<User>> addListUser(@RequestBody List<User> userList) {
        System.out.println(userList);
        list.addAll(userList);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

/**
 * getUser - gets first user.
 * @return - gets first user.
 */
    @RequestMapping(value = "/get_user_2", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserResponse() {
        User user = new User(4, "test", "test");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}