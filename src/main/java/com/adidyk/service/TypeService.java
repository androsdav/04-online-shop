package com.adidyk.service;

import com.adidyk.model.pojo.Type;
import com.adidyk.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        System.out.println("pojo: " + this.repository.findById(type.getId()));
        return  this.repository.findById(type.getId()).orElse(null);
    }

    /**
     * update - update all information for product.
     * @param newType - new product.
     */
    public  Type updateById(Type newType) {
        Type oldType = null;
        if (this.findById(newType) != null) {
            oldType = this.findById(newType);
            if (newType.getName() != null) oldType.setName(newType.getName());
            this.repository.save(oldType);
        }
        return oldType;
    }

    /**
     * deleteById - delete by id.
     * @param type - product.
     */
    public Type deleteById(Type type) {
        Type getType;
        if ((getType = this.findById(type)) != null) {
            this.repository.deleteById(type.getId());
        }
        return getType;
    }

    /**
     * findAll - find and returns all product.
     * @return - returns all product.
     */
    public List<Type> findAll() {
        return this.repository.findAll();
    }

}
