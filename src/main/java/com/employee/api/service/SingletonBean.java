package com.employee.api.service;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Singleton Bean Constructed..............");
    }

    public String getScope(){
        return "This is a Singleton Bean !!!!!!";
    }
}
