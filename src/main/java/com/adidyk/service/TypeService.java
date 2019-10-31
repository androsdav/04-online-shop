package com.adidyk.service;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.TypeDTO;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import com.adidyk.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TypeService.
 */
@Service
public class TypeService {

    /**
     * @param repository - repository.
     */
    private final TypeRepository repository;


    /**
     * ProductService - constructor.
     * @param repository - repository.
     */
    @Autowired
    public TypeService(TypeRepository repository) {
        this.repository = repository;
    }

    /*
    private Product transferDtoToPojo(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getCompany(), productDTO.getModel(), productDTO.getDescription(), productDTO.getQuantity(), productDTO.getPrice());;
    }

    private List<Product> transferDtoToPojo(List<ProductDTO> productDTOS) {
        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDTOS) {
            products.add(this.transferDtoToPojo(productDTO));
        }
        return products;
    }

    private Type transferDtoToPojo(TypeDTO typeDTO) {
        Type type = new Type(typeDTO.getId(), typeDTO.getName());
        return null;
    }
    */

    /**
     * save - save new product.
     * @param type - product.
     */
    public Type save(Type type) {
        return this.repository.save(type);
    }

    /**
     * findById - find product by id and returns.
     * @param type - product.
     * @return - returns product by id.
     */
    public Type findById(Type type) {
        return  this.repository.findById(type.getId()).orElse(null);
    }

    /**
     * update - update all information for product.
     * @param newType - new product.
     */
    /*
    public  void updateById(Type newType) {
        /*
        if (this.findById(newType) != null) {
            Type oldType = this.findById(newType);
            if (newType.getName() != null) oldType.setName(newType.getName());
        }
            this.repository.save(oldType);
            */
    /*
    }*/

    /*
    /**
     * deleteById - delete by id.
     * @param type - product.
     */
    /*
    public void deleteById(Type type) {
        this.repository.deleteById(type.getId());
    }

    /**
     * findAll - find and returns all product.
     * @return - returns all product.
     */
    /*
    public List<Type> findAll() {
        return this.repository.findAll();
    }
    */

}
