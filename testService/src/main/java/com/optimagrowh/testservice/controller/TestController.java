package com.optimagrowh.testservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testpoint")
public class TestController {

    @PostMapping
    public String testMethod() {
        return "String";
    }

    @PostMapping
    public String testMethodTheSecond() {
        return "String";
    }
}