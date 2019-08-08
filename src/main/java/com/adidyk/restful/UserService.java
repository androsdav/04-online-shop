package com.adidyk.restful;

import com.adidyk.models.User;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/get_users")
    public List<User> getAllUser() {
        return list;
    }

    /**
     * getAllUser - returns all users.
     * @return - returns all users.
     */
    @RequestMapping(value = "/get_users_response")
    public ResponseEntity<Object> getAllUserResponse() {
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}