package com.adidyk.restful;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.transfer.ProductTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class SmartPhoneAPI.
 */
@RestController
public class ProductAPI {

    /**
     * @param service - service.
     */
    private final ProductTransfer transfer;

    /**
     * SmartPhone - constructor.
     * @param transfer - service.
     */
    @Autowired
    public ProductAPI(ProductTransfer transfer) {
        this.transfer = transfer;
    }

    /**
     * saveSmartPhone - adds smart phone.
     * @param productDTO - smart phone.
     */
    @RequestMapping(value = "/save_product", method = RequestMethod.POST)
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return this.transfer.save(productDTO);
    }

    /*
    /**
     * saveSmartPhone - find smart phone by id.
     * @param product - smart phone.
     */
    /*
    @RequestMapping(value = "/find_product_by_id", method = RequestMethod.POST)
    public Product findProductById(@RequestBody Product product) {
        return this.service.findById(product);
    }

    /*
    /**
     * saveSmartPhone - update smart phone by id.
     * @param product - smart phone.
     */
    /*
    @RequestMapping(value = "/update_product_by_id", method = RequestMethod.POST)
    public void updateProductById(@RequestBody Product product) {
        this.service.updateById(product);
    }

    /**
     * deleteSmartPhoneById - delete smart phone by id.
     * @param product - smart phone.
     */
    /*
    @RequestMapping(value = "/delete_product_by_id", method = RequestMethod.POST)
    public void deleteProductById(@RequestBody Product product) {
        this.service.deleteById(product);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    /*
    @RequestMapping(value = "/find_all_product", method = RequestMethod.GET)
    public List<Product> findAllProduct() {
        return this.service.findAll();
    }
    */

}