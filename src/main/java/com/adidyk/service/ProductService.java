package com.adidyk.service;

import com.adidyk.model.pojo.Product;
import com.adidyk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class ProductService.
 */
@Service
public class ProductService {

    /**
     * @param repository - repository.
     */
    private final ProductRepository repository;


    /**
     * ProductService - constructor.
     * @param repository - repository.
     */
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * save - save new product.
     * @param product - product.
     */
    public Product save(Product product) {
        return this.repository.save(product);
    }

    /**
     * findById - find product by id and returns.
     * @param product - product.
     * @return - returns product by id.
     */
    public Product findById(Product product) {
        return  this.repository.findById(product.getId()).orElse(null);
    }

    /**
     * update - update all information for product.
     * @param newProduct - new product.
     */
    public  void updateById(Product newProduct) {
        if (this.findById(newProduct) != null) {
            Product oldProduct = this.findById(newProduct);
            if (newProduct.getCompany() != null) oldProduct.setCompany(newProduct.getCompany());
            if (newProduct.getModel() != null) oldProduct.setModel(newProduct.getModel());
            if (newProduct.getDescription() != null) oldProduct.setDescription(newProduct.getDescription());
            if (newProduct.getQuantity() != 0) oldProduct.setQuantity(newProduct.getQuantity());
            if (newProduct.getPrice() != 0) oldProduct.setPrice(newProduct.getPrice());
            this.repository.save(oldProduct);
        }
    }

    /**
     * deleteById - delete by id.
     * @param product - product.
     */
    public void deleteById(Product product) {
        this.repository.deleteById(product.getId());

    }

    /**
     * findAll - find and returns all product.
     * @return - returns all product.
     */
    public List<Product> findAll() {
        return this.repository.findAll();
    }

}