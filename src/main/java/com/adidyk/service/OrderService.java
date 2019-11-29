package com.adidyk.service;

import com.adidyk.model.pojo.Order;
import com.adidyk.model.pojo.User;
import com.adidyk.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class OrderService.
 */
@Service
public class OrderService {

    /**
     * @param repository - repository.
     */
    private final OrderRepository repository;

    /**
     * OrderService - constructor.
     * @param repository - repository.
     */
    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * save - save new order.
     * @param order - order.
     */
    public void save(Order order) {
        this.repository.save(order);
    }

    /**
     *
     * @param order - order.
     * @return - returns order.
     */
    public Order findById(Order order) {
        return this.repository.findById(order.getId()).orElse(null);
    }

    /**
     *
     * @param user - user.
     * @return - list.
     */
    public List<Order> findAllByUser(User user) {
        List<Order> list = this.repository.findAllByUser(user);
        System.out.println("               --> " + list);
        //return this.repository.findAllByUser(user);
        return list;
    }

}