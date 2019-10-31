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

@Service
public class TypeTransfer {


    private TypeService service;

    @Autowired
    public TypeTransfer(TypeService service) {
        this.service = service;
    }

    private Product transferDtoToPojo(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getCompany(), productDTO.getModel(), productDTO.getDescription(), productDTO.getQuantity(), productDTO.getPrice());
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
        if (typeDTO.getProducts() != null) type.setProducts(this.transferDtoToPojo(typeDTO.getProducts()));
        return type;
    }


    private ProductDTO transferPojoToDto(Product product) {
        return new ProductDTO(product.getId(), product.getCompany(), product.getModel(), product.getDescription(), product.getQuantity(), product.getPrice());
    }

    private List<ProductDTO> transferPojoToDto(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(this.transferPojoToDto(product));
        }
        return productDTOS;
    }

    private TypeDTO transferPojoToDto(Type type) {
        TypeDTO typeDTO = new TypeDTO(type.getId(), type.getName());
        if (type.getProducts() != null) typeDTO.setProducts(this.transferPojoToDto(type.getProducts()));
        return typeDTO;
    }

    /**
     * save - save new product.
     * @param typeDTO - product.
     */
    public TypeDTO save(TypeDTO typeDTO) {
        //Type type = this.transferDtoToPojo(typeDTO);
        //System.out.println();
        //System.out.println("type pojo: " + type);
        //Type type = this.service.save(this.transferDtoToPojo(typeDTO));
        return this.transferPojoToDto(this.service.save(this.transferDtoToPojo(typeDTO)));
    }

    /**
     * findById - find product by id and returns.
     * @param typeDTO - product.
     * @return - returns product by id.
     */
    public TypeDTO findById(TypeDTO typeDTO) {
        return  this.transferPojoToDto(this.service.findById(this.transferDtoToPojo(typeDTO)));
    }



}
