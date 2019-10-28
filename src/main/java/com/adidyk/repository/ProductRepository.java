package com.adidyk.repository;

import com.adidyk.model.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface SmartPhoneRepository.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}