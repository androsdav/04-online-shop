package com.adidyk.transfer;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.TypeDTO;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import com.adidyk.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class TypeTransfer {

    /**
     *
     */
    private TypeService service;

    /**
     *
     * @param service - service.
     */
    @Autowired
    public TypeTransfer(TypeService service) {
        this.service = service;
    }

    /**
     *
     * @param typeDTO - is.
     * @return - is.
     */
    private Type transferDtoToPojo(TypeDTO typeDTO) {
        return new Type(typeDTO.getId(), typeDTO.getName());
    }


    /**
     * transferPojoToDto - transfer.
     * @param type - is.
     * @return - is.
     */
    private TypeDTO transferPojoToDto(Type type) {
        TypeDTO typeDTO = null;
        if (type != null) {
            typeDTO = new TypeDTO(type.getId(), type.getName());
        }
        return typeDTO;
    }

    /**
     * transferPojoListToDtoList - transfer.
     * @param types - is.
     * @return - is.
     */
    private List<TypeDTO> transferPojoListToDtoList(List<Type> types) {
        List<TypeDTO> typeDTOS = new ArrayList<>();
        for (Type type : types) {
            typeDTOS.add(this.transferPojoToDto(type));
        }
        return typeDTOS;
    }

    /**
     * save - save new product.
     * @param typeDTO - product.
     */
    public TypeDTO save(TypeDTO typeDTO) {
        return this.transferPojoToDto(this.service.save(this.transferDtoToPojo(typeDTO)));
    }

    /**
     * findById - find product by id and returns.
     * @param typeDTO - product.
     * @return - returns product by id.
     */
    public TypeDTO findById(TypeDTO typeDTO) {
        return this.transferPojoToDto(this.service.findById(this.transferDtoToPojo(typeDTO)));
    }

    /**
     * update - update all information for product.
     * @param typeDTO - new product.
     */
    public  TypeDTO updateById(TypeDTO typeDTO) {
        return this.transferPojoToDto(this.service.updateById(this.transferDtoToPojo(typeDTO)));
    }

    /**
     * deleteById - delete by id.
     * @param typeDTO - product.
     */
    public TypeDTO deleteById(TypeDTO typeDTO) {
        return this.transferPojoToDto(this.service.deleteById(this.transferDtoToPojo(typeDTO)));
    }

    /**
     * findAll - find all.
     * @return - return.
     */
    public List<TypeDTO> findAll() {
        return this.transferPojoListToDtoList(this.service.findAll());
    }

}