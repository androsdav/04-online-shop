package com.adidyk.repository;

import com.adidyk.model.pojo.Order;
import com.adidyk.model.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface OrderRepository.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByUser(User user);

}