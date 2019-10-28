package com.adidyk.restful;

import com.adidyk.model.pojo.Product;
import com.adidyk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Class SmartPhoneAPI.
 */
@RestController
public class ProductAPI {

    /**
     * @param service - service.
     */
    private final ProductService service;

    /**
     * SmartPhone - constructor.
     * @param service - service.
     */
    @Autowired
    public ProductAPI(ProductService service) {
        this.service = service;
    }

    /**
     * saveSmartPhone - adds smart phone.
     * @param product - smart phone.
     */
    @RequestMapping(value = "/save_product", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product) {
        System.out.println();
        System.out.println(product);
        System.out.println();
        //return product;
        return this.service.save(product);
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param product - smart phone.
     */
    @RequestMapping(value = "/find_product_by_id", method = RequestMethod.POST)
    public Product findProductById(@RequestBody Product product) {
        return this.service.findById(product);
    }

    /**
     * saveSmartPhone - update smart phone by id.
     * @param product - smart phone.
     */
    @RequestMapping(value = "/update_product_by_id", method = RequestMethod.POST)
    public void updateProductById(@RequestBody Product product) {
        this.service.updateById(product);
    }

    /**
     * deleteSmartPhoneById - delete smart phone by id.
     * @param product - smart phone.
     */
    @RequestMapping(value = "/delete_product_by_id", method = RequestMethod.POST)
    public void deleteProductById(@RequestBody Product product) {
        this.service.deleteById(product);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    @RequestMapping(value = "/find_all_product", method = RequestMethod.GET)
    public List<Product> findAllProduct() {
        return this.service.findAll();
    }

}