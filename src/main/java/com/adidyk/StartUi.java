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
        /*
        SmartPhone iphone = new SmartPhone("apple", "70", "smart phone", 10);
        SmartPhone nokia = new SmartPhone("nokia", "71", "smart phone", 5);
        SmartPhone samsung = new SmartPhone("samsung", "galaxy", "smart phone", 3);
        SmartPhone lg = new SmartPhone("lg", "11", "smart phone", 4);
        this.service.add(iphone);
        this.service.add(nokia);
        this.service.add(samsung);
        this.service.add(lg);
        */
        /*
        SmartPhone lg = new SmartPhone(10,"lg", "11", "smart phone", 66);
        //this.service.update(lg);
        System.out.println(this.service.get(7));
        System.out.println(this.service.get(8));
        System.out.println(this.service.get(9));
        System.out.println(this.service.get(10));
        System.out.println(this.service.get(11));

        for (SmartPhone smartPhone : this.service.getAll()) {
            System.out.println(smartPhone);
        }
        SmartPhone item = new SmartPhone();
        item.setCompany("nokia");
        System.out.println(this.service.findAllByCompany(item));
        */

    }

}