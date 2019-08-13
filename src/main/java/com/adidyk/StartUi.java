package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class StartUi.
 */
@SpringBootApplication
public class StartUi {

    /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        System.out.println("viber-bot");
        System.getProperties().put("server.port", 8081);
        SpringApplication.run(StartUi.class, arg);
    }

}