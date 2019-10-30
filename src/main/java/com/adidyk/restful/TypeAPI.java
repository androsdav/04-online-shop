package com.adidyk.restful;

import com.adidyk.model.pojo.Product;
import com.adidyk.model.pojo.Type;
import com.adidyk.service.TypeService;
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
    private final TypeService service;

    /**
     * SmartPhone - constructor.
     * @param service - service.
     */
    @Autowired
    public TypeAPI(TypeService service) {
        this.service = service;
    }

    /**
     * saveSmartPhone - adds smart phone.
     * @param type - smart phone.
     */
    @RequestMapping(value = "/save_type", method = RequestMethod.POST)
    public Type saveType(@RequestBody Type type) {
        return this.service.save(type);
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param type - smart phone.
     */
    @RequestMapping(value = "/find_type_by_id", method = RequestMethod.POST)
    public Type findTypeById(@RequestBody Type type) {
        return this.service.findById(type);
    }

    /**
     * saveSmartPhone - update smart phone by id.
     * @param type - smart phone.
     */
    @RequestMapping(value = "/update_type_by_id", method = RequestMethod.POST)
    public void updateTypeById(@RequestBody Type type) {
        this.service.updateById(type);
    }

    /**
     * deleteSmartPhoneById - delete smart phone by id.
     * @param type - smart phone.
     */
    @RequestMapping(value = "/delete_type_by_id", method = RequestMethod.POST)
    public void deleteTypeById(@RequestBody Type type) {
        this.service.deleteById(type);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    @RequestMapping(value = "/find_all_type", method = RequestMethod.GET)
    public List<Type> findAllType() {
        return this.service.findAll();
    }

}
