package com.adidyk.repository;

import com.adidyk.model.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface OrderRepository.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}