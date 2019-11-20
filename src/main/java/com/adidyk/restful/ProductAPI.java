package com.adidyk.restful;

import com.adidyk.model.dto.ProductDTO;
import com.adidyk.model.dto.TypeDTO;
import com.adidyk.transfer.ProductTransfer;
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

    /**
     * saveSmartPhone - find smart phone by id.
     * @param productDTO - smart phone.
     */
    @RequestMapping(value = "/find_product_by_id", method = RequestMethod.POST)
    public ProductDTO findProductById(@RequestBody ProductDTO productDTO) {
        return this.transfer.findById(productDTO);
    }

    /**
     * saveSmartPhone - update smart phone by id.
     * @param productDTO - smart phone.
     */
    @RequestMapping(value = "/update_product_by_id", method = RequestMethod.POST)
    public ProductDTO updateProductById(@RequestBody ProductDTO productDTO) {
        return this.transfer.updateById(productDTO);
    }

    /**
     * deleteSmartPhoneById - delete smart phone by id.
     * @param productDTO - smart phone.
     */
    @RequestMapping(value = "/delete_product_by_id", method = RequestMethod.POST)
    public ProductDTO deleteProductById(@RequestBody ProductDTO productDTO) {
        return this.transfer.deleteById(productDTO);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    @RequestMapping(value = "/find_all_product", method = RequestMethod.GET)
    public List<ProductDTO> findAllProduct() {
        return this.transfer.findAll();
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    @RequestMapping(value = "/find_all_product_by_type", method = RequestMethod.POST)
    public List<ProductDTO> findAllProductByType(@RequestBody TypeDTO typeDTO) {
        return this.transfer.findAllByType(typeDTO);
    }

}