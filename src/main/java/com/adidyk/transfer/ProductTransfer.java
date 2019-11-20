package com.adidyk.transfer;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.TypeDTO;
import com.adidyk.service.ProductService;
import com.adidyk.transfer.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class ProductTransfer.
 */
@Service
public class ProductTransfer {

    /**
     * @param service - service.
     */
    private ProductService service;

    /**
     * @param mapper - mapper.
     */
    private ProductMapper mapper;

    /**
     * ProductTransfer - constructor.
     * @param service - is.
     */
    @Autowired
    public ProductTransfer(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * save - save new product.
     * @param productDTO - product.
     */
    public ProductDTO save(ProductDTO productDTO) {
        return this.mapper.toProductDTO(this.service.save(this.mapper.toProduct(productDTO)));
    }

    /**
     * findById - find by id.
     * @param productDTO - is.
     * @return - is.
     */
    public ProductDTO findById(ProductDTO productDTO) {
        return this.mapper.toProductDTO(this.service.findById(this.mapper.toProduct(productDTO)));
    }

    /**
     * updateById - update by id.
     * @param productDTO - is.
     * @return - is.
     */
    public ProductDTO updateById(ProductDTO productDTO) {
        return this.mapper.toProductDTO(this.service.updateById(this.mapper.toProduct(productDTO)));
    }

    /**
     * deleteById - delete by id.
     * @param productDTO - is.
     * @return - is.
     */
    public ProductDTO deleteById(ProductDTO productDTO) {
        return this.mapper.toProductDTO(this.service.deleteById(this.mapper.toProduct(productDTO)));
    }

    /**
     * findAll - find and returns all product.
     * @return - returns all product.
     */
    public List<ProductDTO> findAll() {
        return this.mapper.toListProductDTO(this.service.findAll());
    }

    /**
     * findAll - find and returns all product.
     * @return - returns all product.
     */
    public List<ProductDTO> findAllByType(TypeDTO typeDTO) {
        return this.mapper.toListProductDTO(this.service.findAllByType(this.mapper.toType(typeDTO)));
    }

}