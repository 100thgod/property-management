package com.saurabh.propertymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertyManagementApplication {

    public static void main(String[] args) {
//        SpringApplication.run(PropertyManagementApplication.class, args);
        SpringApplication app = new SpringApplication(PropertyManagementApplication.class);
        app.run(args);
    }

}
