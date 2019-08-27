package com.adidyk.restful;

import com.adidyk.model.SmartPhone;
import com.adidyk.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
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
     *
     */
    private final SmartPhoneService service;

    /**
     *
     * @param service
     */
    @Autowired
    public SmartPhoneAPI(SmartPhoneService service) {
        this.service = service;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/get_all_smart_phone", method = RequestMethod.GET)
    public List<SmartPhone> getAllSmartPhone() {
        return this.service.findAll();
    }
}
