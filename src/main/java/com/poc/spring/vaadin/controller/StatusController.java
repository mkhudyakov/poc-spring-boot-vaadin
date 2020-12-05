package com.poc.spring.vaadin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.ALL_VALUE;

@RestController
public class StatusController {

    @GetMapping(value = "/status", consumes = ALL_VALUE, produces = ALL_VALUE)
    public String getStatus() {
        return "OK";
    }
}
