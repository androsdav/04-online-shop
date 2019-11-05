package com.adidyk.transfer;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.TypeDTO;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import com.adidyk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProductTransfer {

    /**
     * @param service - service.
     */
    private ProductService service;

    /**
     * ProductTransfer - constructor.
     * @param service - is.
     */
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
        Product product = new Product(productDTO.getId(), productDTO.getCompany(), productDTO.getModel(),
                productDTO.getDescription(), productDTO.getQuantity(), productDTO.getPrice());
        if (productDTO.getType() != null) {
            product.setType(this.transferDtoToPojo(productDTO.getType()));
        }
        return product;
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
        ProductDTO productDTO = null;
        if (product != null) {
            productDTO = new ProductDTO(product.getId(), product.getCompany(), product.getModel(), product.getDescription(),
                    product.getQuantity(), product.getPrice(), this.transferPojoToDto(product.getType()));

        }
        return productDTO;
    }

    /**
     * save - save new product.
     * @param productDTO - product.
     */
    public ProductDTO save(ProductDTO productDTO) {
        return this.transferPojoToDto(this.service.save(this.transferDtoToPojo(productDTO)));
    }

    /**
     * findById - find by id.
     * @param productDTO - is.
     * @return - is.
     */
    public ProductDTO findById(ProductDTO productDTO) {
        return this.transferPojoToDto(this.service.findById(this.transferDtoToPojo(productDTO)));
    }

    /**
     * updateById - update by id.
     * @param productDTO - is.
     * @return - is.
     */
    public ProductDTO updateById(ProductDTO productDTO) {
        return this.transferPojoToDto(this.service.updateById(this.transferDtoToPojo(productDTO)));
    }

    /**
     * deleteById - delete by id.
     * @param productDTO - is.
     * @return - is.
     */
    public ProductDTO deleteById(ProductDTO productDTO) {
        return this.transferPojoToDto(this.service.deleteById(this.transferDtoToPojo(productDTO)));
    }

}
