package com.adidyk.restful;

import com.adidyk.model.Order;
import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPI {

    private final UserService userService;

    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    //public void addOrder(@RequestBody List<SmartPhone> list) {
    public void addUser(@RequestBody User user) {
        //Order order = new Order();
        //order.setSmartPhones(list);
        //this.orderService.save(order);
        System.out.println(user);
        this.userService.save(user);
    }

}
