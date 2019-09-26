package com.adidyk.restful;

import com.adidyk.model.Order;
import com.adidyk.model.SmartPhone;
import com.adidyk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderAPI {

    private final OrderService orderService;

    @Autowired
    public OrderAPI(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * addSmartPhone - adds smart phone.
     * @param list - smart phone.
     */
    @RequestMapping(value = "/add_order", method = RequestMethod.POST)
    public void addOrder(@RequestBody List<SmartPhone> list) {
        Order order = new Order();
        order.setSmartPhones(list);
        this.orderService.save(order);
        //System.out.println(list);

        //this.orderService.save(order);
    }

}