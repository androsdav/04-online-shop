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
 * Class SmartPhone.
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
    public SmartPhone saveSmartPhone(@RequestBody SmartPhone smartPhone) {
        return this.service.save(smartPhone);
    }

    /**
     * saveSmartPhone - find smart phone by id.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/find_smart_phone_by_id", method = RequestMethod.POST)
    public SmartPhone findSmartPhoneById(@RequestBody SmartPhone smartPhone) {
        return this.service.findById(smartPhone);
    }

    /**
     * saveSmartPhone - update smart phone by id.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/update_smart_phone_by_id", method = RequestMethod.POST)
    public void updateSmartPhoneById(@RequestBody SmartPhone smartPhone) {
        this.service.updateById(smartPhone);
    }

    /**
     * deleteSmartPhoneById - delete smart phone by id.
     * @param smartPhone - smart phone.
     */
    @RequestMapping(value = "/delete_smart_phone_by_id", method = RequestMethod.POST)
    public void deleteSmartPhoneById(@RequestBody SmartPhone smartPhone) {
        System.out.println();
        System.out.println(smartPhone);
        this.service.deleteById(smartPhone);
    }

    /**
     * getAllSmartPhone - gets all smart phone.
     * @return - returns all smart phone.
     */
    @RequestMapping(value = "/find_all_smart_phone", method = RequestMethod.GET)
    public List<SmartPhone> findAllSmartPhone() {
        return this.service.findAll();
    }

}