package com.adidyk.transfer;

import com.adidyk.model.dto.TypeDTO;
import com.adidyk.service.TypeService;
import com.adidyk.transfer.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class TypeTransfer.
 */
@Service
public class TypeTransfer {

    /**
     * @param service - service.
     */
    private TypeService service;

    /**
     * @param mapper - mapper.
     */
    private TypeMapper mapper;

    /**
     * TypeService - constructor.
     * @param service - service.
     * @param mapper - mapper.
     */
    @Autowired
    public TypeTransfer(TypeService service, TypeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * save - save new product.
     * @param typeDTO - product.
     */
    public TypeDTO save(TypeDTO typeDTO) {
        return this.mapper.toTypeDTO(this.service.save(this.mapper.toType(typeDTO)));
    }

    /**
     * findById - find product by id and returns.
     * @param typeDTO - product.
     * @return - returns product by id.
     */
    public TypeDTO findById(TypeDTO typeDTO) {
        return this.mapper.toTypeDTO(this.service.findById(this.mapper.toType(typeDTO)));
    }

    /**
     * update - update all information for product.
     * @param typeDTO - new product.
     */
    public  TypeDTO updateById(TypeDTO typeDTO) {
        return this.mapper.toTypeDTO(this.service.updateById(this.mapper.toType(typeDTO)));
    }

    /**
     * deleteById - delete by id.
     * @param typeDTO - product.
     */
    public TypeDTO deleteById(TypeDTO typeDTO) {
        return this.mapper.toTypeDTO(this.service.deleteById(this.mapper.toType(typeDTO)));
    }

    /**
     * findAll - find all.
     * @return - return.
     */
    public List<TypeDTO> findAll() {
        return this.mapper.toListTypeDTO(this.service.findAll());
    }

}