package com.adidyk.restful;

import com.adidyk.model.SmartPhone;
import com.adidyk.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
public class SmartPhoneAPI {

    /**
     * @param service - service.
     */
    private final SmartPhoneService service;

    /**
     * SmartPhone - constructor.
     * @param service - service.
     */
    @Autowired
    public SmartPhoneAPI(SmartPhoneService service) {
        this.service = service;
    }

    /**
     * addSmartPhone - adds smart phone.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/add_smart_phone", method = RequestMethod.POST)
    public void addSmartPhone(@RequestBody SmartPhone smartPhone) {
        this.service.save(smartPhone);
    }

    @RequestMapping(value = "/delete_smart_phone", method = RequestMethod.POST)
    public void deleteSmartPhone(@RequestBody SmartPhone smartPhone) {
        System.out.println(smartPhone);
        this.service.deleteById(smartPhone);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    @RequestMapping(value = "/get_all_smart_phone", method = RequestMethod.GET)
    public List<SmartPhone> getAllSmartPhone() {
        return this.service.findAll();
    }

}