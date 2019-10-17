package com.adidyk.restful;

import com.adidyk.model.Order;
import com.adidyk.model.SmartPhone;
import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class UserAPI.
 */
@RestController
public class UserAPI {

    /**
     * @param service - service.
     */
    private final UserService service;

    /**
     * UserAPI - constructor.
     * @param service - service.
     */
    @Autowired
    public UserAPI(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    //public void addOrder(@RequestBody List<SmartPhone> list) {
    public User saveUser(@RequestBody User user) {
        //Order order = new Order();
        //order.setSmartPhones(list);
        //this.orderService.save(order);
        System.out.println(user);
        return this.service.save(user);
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param user - smart phone.
     */
    @RequestMapping(value = "/find_user_by_login_and_password", method = RequestMethod.POST)
    public User findUserByLoginAndPassword(@RequestBody User user) {
        System.out.println(user);
        User findUser = this.service.findByLoginAndPassword(user);
        System.out.println(findUser);
        return findUser;
        //return this.service.findByLoginAndPassword(user);
    }

    /**
     *
     * @param user - user.
     * @return - return.
     */
    @RequestMapping(value = "/find_user_by_id", method = RequestMethod.GET)
    public User findUserById(@RequestBody User user) {
        return this.service.findById(user);
    }

}
