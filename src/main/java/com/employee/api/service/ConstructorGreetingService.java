package com.employee.api.service;

import org.springframework.stereotype.Service;


public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "hello World -- Constructor";
    }
}
