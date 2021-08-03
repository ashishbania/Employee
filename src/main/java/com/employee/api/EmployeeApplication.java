package com.employee.api;

import com.employee.api.controller.EmployeeController;
import com.employee.api.controller.GreetingController;
import com.employee.api.controller.I18nController;
import com.employee.api.service.PrototypeBean;
import com.employee.api.service.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        ApplicationContext x = SpringApplication.run(EmployeeApplication.class, args);

        EmployeeController employeeController = (EmployeeController) x.getBean("employeeController");
//        System.out.println(employeeController.getAllEmployees());

        GreetingController greetingController= (GreetingController) x.getBean("greetingController");
        System.out.println(greetingController.fetchGreeting());

        I18nController englishGreetingController= (I18nController) x.getBean("i18nController");
        System.out.println(englishGreetingController.sayGreeting());

        SingletonBean singletonBean= (SingletonBean) x.getBean("singletonBean");
        System.out.println(singletonBean.getScope());
        SingletonBean singletonBean2= (SingletonBean) x.getBean("singletonBean");
        System.out.println(singletonBean2.getScope());
        SingletonBean singletonBean3= (SingletonBean) x.getBean("singletonBean");
        System.out.println(singletonBean3.getScope());

        PrototypeBean prototypeBean1 = x.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getScope());
        PrototypeBean prototypeBean2 = x.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getScope());


    }

}
