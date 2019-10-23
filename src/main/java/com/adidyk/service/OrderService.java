package com.adidyk.service;

import com.adidyk.model.Order;
import com.adidyk.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Order save(Order order) {
        return this.repository.save(order);
    }

    /**
     *
     * @param order - order.
     * @return - returns order.
     */
    public Order findById(Order order) {
        return this.repository.findById(order.getId()).orElse(null);
    }

}