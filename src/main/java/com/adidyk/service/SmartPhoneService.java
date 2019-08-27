package com.adidyk.service;

import com.adidyk.model.SmartPhone;
import com.adidyk.repository.SmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SmartPhoneService {

    /**
     *
     */
    private final SmartPhoneRepository repository;


    /**
     *
     * @param repository - repository.
     */
    @Autowired
    public SmartPhoneService(SmartPhoneRepository repository) {
        this.repository = repository;
    }

    /**
     * save - save new smart phone.
     * @param smartPhone - smart phone.
     */
    public void save(SmartPhone smartPhone) {
        this.repository.save(smartPhone);
    }

    /**
     * findById - find smart phone by id and returns.
     * @param id - id smart phone.
     * @return - returns smart phone by id.
     */
    public SmartPhone findById(Integer id) {
        return  this.repository.findById(id).orElse(null);
    }

    /**
     * update - update all information for smart phone.
     * @param newSmartPhone - new smart phone.
     */
    public  void update(SmartPhone newSmartPhone) {
        SmartPhone oldSmartPhone = this.findById(newSmartPhone.getId());
        oldSmartPhone.setCompany(newSmartPhone.getCompany());
        oldSmartPhone.setModel(newSmartPhone.getModel());
        oldSmartPhone.setDescription(newSmartPhone.getDescription());
        oldSmartPhone.setQuantity(newSmartPhone.getQuantity());
        this.repository.save(oldSmartPhone);
    }

    /**
     * findAll - find and returns all smart phone.
     * @return - returns all smart phone.
     */
    public List<SmartPhone> findAll() {
        return this.repository.findAll();
    }

}