package com.adidyk.repository;

import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interface SmartPhoneRepository.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * findAllByType - is.
     * @param type - type.
     * @return - list.
     */
    List<Product> findAllByType(Type type);

}