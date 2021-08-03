package com.employee.api.controller;

import com.employee.api.service.ConstructorGreetingService;
import com.employee.api.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    private final ConstructorGreetingService greetingService;

    public GreetingController(ConstructorGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String fetchGreeting(){
        return greetingService.sayGreeting();
    }
}
