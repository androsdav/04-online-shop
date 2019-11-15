package com.adidyk.repository;

import com.adidyk.model.pojo.Order;
import com.adidyk.model.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface OrderRepository.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByUser(User user);

}