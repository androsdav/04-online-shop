package com.adidyk.restful;

import com.adidyk.model.dto.TypeDTO;
import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import com.adidyk.service.TypeService;
import com.adidyk.transfer.TypeTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeAPI {

    /**
     * @param service - service.
     */
    private final TypeTransfer transfer;

    /**
     * SmartPhone - constructor.
     * @param transfer - service.
     */
    @Autowired
    public TypeAPI(TypeTransfer transfer) {
        this.transfer = transfer;
    }

    /**
     * saveSmartPhone - adds smart phone.
     * @param typeDTO - smart phone.
     */
    @RequestMapping(value = "/save_type", method = RequestMethod.POST)
    public TypeDTO saveType(@RequestBody TypeDTO typeDTO) {
        //System.out.println();
        //System.out.println("type dto: " + typeDTO);
        return this.transfer.save(typeDTO);
        //return typeDTO;
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param typeDTO - smart phone.
     */
    @RequestMapping(value = "/find_type_by_id", method = RequestMethod.POST)
    public TypeDTO findTypeById(@RequestBody TypeDTO typeDTO) {
        return this.transfer.findById(typeDTO);
    }

    /*
    /**
     * saveSmartPhone - update smart phone by id.
     * @param type - smart phone.
     */
    /*
    @RequestMapping(value = "/update_type_by_id", method = RequestMethod.POST)
    public void updateTypeById(@RequestBody Type type) {
        this.service.updateById(type);
    }

    /**
     * deleteSmartPhoneById - delete smart phone by id.
     * @param type - smart phone.
     */
    /*
    @RequestMapping(value = "/delete_type_by_id", method = RequestMethod.POST)
    public void deleteTypeById(@RequestBody Type type) {
        this.service.deleteById(type);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    /*
    @RequestMapping(value = "/find_all_type", method = RequestMethod.GET)
    public List<Type> findAllType() {
        return this.service.findAll();
    }
    */

}
