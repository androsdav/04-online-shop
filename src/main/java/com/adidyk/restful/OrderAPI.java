package com.adidyk.restful;

import com.adidyk.model.dto.OrderDTO;
import com.adidyk.model.dto.UserDTO;
import com.adidyk.model.pojo.Order;
import com.adidyk.service.OrderService;
import com.adidyk.transfer.OrderTransfer;
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
    private final OrderTransfer transfer;

    /**
     * OrderAPI - constructor.
     * @param transfer - service.
     */
    @Autowired
    public OrderAPI(OrderTransfer transfer) {
        this.transfer = transfer;
    }

    /**
     * addSmartPhone - adds smart phone.
     * @param order - smart phone.
     */
    @RequestMapping(value = "/save_order", method = RequestMethod.POST)
    //public void addOrder(@RequestBody List<SmartPhone> list) {
    public void saveOrder(@RequestBody OrderDTO order) {
        //Order order = new Order();
        //order.setSmartPhones(list);
        //this.orderService.save(order);
        System.out.println();
        System.out.println();
        System.out.println(order);
        System.out.println();
        System.out.println();
        //System.out.println(order.getSmartPhones());
        this.transfer.save(order);
    }

    /**
     *
     * @param order - order.
     * @return - return.
     */
    /*
    @RequestMapping(value = "find_order_by_id", method = RequestMethod.POST)
    public void findOrderById(@RequestBody OrderDTO order) {
        this.transfer.findById(order);
    }
    */
    @RequestMapping(value = "find_order_by_id", method = RequestMethod.POST)
    public Order findOrderById(@RequestBody Order order) {
        return this.transfer.findById(order);
    }

    @RequestMapping(value = "find_all_order_by_user", method = RequestMethod.POST)
    public void findAllOrderByUser(@RequestBody UserDTO user) {
        this.transfer.findAllByUser(user);
    }


}