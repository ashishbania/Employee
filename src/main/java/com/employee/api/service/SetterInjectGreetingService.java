package com.employee.api.service;

public class SetterInjectGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World -- Setter";
    }
}
