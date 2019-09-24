package com.adidyk.service;

import com.adidyk.model.Order;
import com.adidyk.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @param order - order.
     */
    public void save(Order order) {
        this.repository.save(order);
    }

}