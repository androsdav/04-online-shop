package com.adidyk.transfer;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.TypeDTO;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import com.adidyk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTransfer {

    private ProductService service;

    @Autowired
    public ProductTransfer(ProductService service) {
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
     *
     * @param productDTO - is.
     * @return - is.
     */
    private Product transferDtoToPojo(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getCompany(), productDTO.getModel(), productDTO.getDescription(),
                productDTO.getQuantity(), productDTO.getPrice(), this.transferDtoToPojo(productDTO.getType()));
    }

    /**
     *
     * @param type - is.
     * @return - is.
     */
    private TypeDTO transferPojoToDto(Type type) {
        return new TypeDTO(type.getId(), type.getName());
    }

    /**
     *
     * @param product - is.
     * @return - is.
     */
    private ProductDTO transferPojoToDto(Product product) {
        return new ProductDTO(product.getId(), product.getCompany(), product.getModel(), product.getDescription(),
                product.getQuantity(), product.getPrice(), this.transferPojoToDto(product.getType()));
    }


    /**
     * save - save new product.
     * @param productDTO - product.
     */
    public ProductDTO save(ProductDTO productDTO) {
        return this.transferPojoToDto(this.service.save(this.transferDtoToPojo(productDTO)));
    }

}
