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
     * saveSmartPhone - adds smart phone.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/save_smart_phone", method = RequestMethod.POST)
    public void saveSmartPhone(@RequestBody SmartPhone smartPhone) {
        this.service.save(smartPhone);
    }

    /**
     * saveSmartPhone - adds smart phone.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/find_smart_phone_by_id", method = RequestMethod.POST)
    public SmartPhone findSmartPhoneById(@RequestBody SmartPhone smartPhone) {
        System.out.println(smartPhone);
        return this.service.findById(smartPhone);
    }

    /**
     * saveSmartPhone - adds smart phone.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/update_smart_phone", method = RequestMethod.POST)
    public void updateSmartPhone(@RequestBody SmartPhone smartPhone) {
        this.service.update(smartPhone);
    }

    /**
     * deleteSmartPhoneById - delete smart phone by id.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/delete_smart_phone_by_id", method = RequestMethod.POST)
    public void deleteSmartPhoneById(@RequestBody SmartPhone smartPhone) {
        this.service.deleteById(smartPhone);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    @RequestMapping(value = "/get_all_smart_phone", method = RequestMethod.GET)
    public List<SmartPhone> findAllSmartPhone() {
        return this.service.findAll();
    }

}