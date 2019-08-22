package com.adidyk;

import com.adidyk.model.SmartPhone;
import com.adidyk.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * Class StartUi.
 */
@SpringBootApplication
public class StartUi {

    /**
     *
     */
    private final SmartPhoneService service;

    @Autowired
    public StartUi(SmartPhoneService service) {
        this.service = service;
    }


    /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        System.out.println("viber-bot");
        System.getProperties().put("server.port", 8081);
        SpringApplication.run(StartUi.class, arg);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void testJpaMethods(){
        SmartPhone iphone = new SmartPhone("123", "234", "567", 124);
        //this.service.create(iphone);
        this.service.
    }

}