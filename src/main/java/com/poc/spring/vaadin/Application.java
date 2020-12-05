package com.poc.spring.vaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.poc.spring.vaadin")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
