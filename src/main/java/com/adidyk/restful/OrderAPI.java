package com.adidyk.restful;

import com.adidyk.model.Order;
import com.adidyk.model.SmartPhone;
import com.adidyk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderAPI.
 */
@RestController
public class OrderAPI {

    /**
     * @param orderService
     */
    private final OrderService service;

    /**
     * OrderAPI - constructor.
     * @param service - service.
     */
    @Autowired
    public OrderAPI(OrderService service) {
        this.service = service;
    }

    /**
     * addSmartPhone - adds smart phone.
     * @param order - smart phone.
     */
    @RequestMapping(value = "/save_order", method = RequestMethod.POST)
    //public void addOrder(@RequestBody List<SmartPhone> list) {
    public Order saveOrder(@RequestBody Order order) {
        //Order order = new Order();
        //order.setSmartPhones(list);
        //this.orderService.save(order);
        System.out.println();
        System.out.println();
        System.out.println(order);
        System.out.println();
        System.out.println();
        //System.out.println(order.getSmartPhones());
        return this.service.save(order);
    }

    /**
     *
     * @param order - order.
     * @return - return.
     */
    @RequestMapping(value = "find_order_by_id", method = RequestMethod.GET)
    public Order findOrderById(@RequestBody Order order) {
        return this.service.findById(order);
    }

}