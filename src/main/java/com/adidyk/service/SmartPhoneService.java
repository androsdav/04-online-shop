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
     * SmartPhoneService - constructor.
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
     * @param smartPhone - smart phone.
     * @return - returns smart phone by id.
     */
    public SmartPhone findById(SmartPhone smartPhone) {
        return  this.repository.findById(smartPhone.getId()).orElse(null);
    }

    /**
     * update - update all information for smart phone.
     * @param newSmartPhone - new smart phone.
     */
    public  void update(SmartPhone newSmartPhone) {
        SmartPhone oldSmartPhone = this.findById(newSmartPhone);
        if (newSmartPhone.getCompany() != null) oldSmartPhone.setCompany(newSmartPhone.getCompany());
        if (newSmartPhone.getModel() != null) oldSmartPhone.setModel(newSmartPhone.getModel());
        if (newSmartPhone.getDescription() != null) oldSmartPhone.setDescription(newSmartPhone.getDescription());
        if (newSmartPhone.getQuantity() != 0) oldSmartPhone.setQuantity(newSmartPhone.getQuantity());
        if (newSmartPhone.getPrice() != 0) oldSmartPhone.setPrice(newSmartPhone.getPrice());
        this.repository.save(oldSmartPhone);
    }

    /**
     * deleteById - delete by id.
     * @param smartPhone - smart phone.
     */
    public void deleteById(SmartPhone smartPhone) {
        this.repository.deleteById(smartPhone.getId());

    }

    /**
     * findAll - find and returns all smart phone.
     * @return - returns all smart phone.
     */
    public List<SmartPhone> findAll() {
        return this.repository.findAll();
    }

}