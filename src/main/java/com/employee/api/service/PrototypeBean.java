package com.employee.api.service;

import org.springframework.aop.aspectj.annotation.PrototypeAspectInstanceFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("Prototype Bean Constructed..............");
    }

    public String getScope(){
        return "This is a Prototype Bean !!!!!!";
    }
}
