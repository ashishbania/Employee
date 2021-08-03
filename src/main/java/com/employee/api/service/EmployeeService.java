package com.employee.api.service;

import com.employee.api.model.Employee;
import com.employee.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployeeById(Long id){
        System.out.println("In Service get by id emp");
        return employeeRepository.findById(id);
    }
//    @Async("asynctaskExecuter")
    public List<Employee> getEmpLesserAge(Long age){
        System.out.println("getEmpLesserAge -- started");
        List<Employee> employeeList=employeeRepository.findAll();
        List<Employee> filteredEmp = employeeList.stream()
                .filter(employee -> employee.getAge()<age)
                .collect(Collectors.toList());
        System.out.println("getEmpLesserAge -- completed");
        return filteredEmp;
//        return CompletableFuture.completedFuture(filteredEmp);
    }
    @Async("asynctaskExecuter")
    public CompletableFuture<List<Employee>> getAllEmployee() throws InterruptedException{
        System.out.println("getAllEmployee -- started");
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
//        System.out.println(employeeList);
//        Thread.sleep(1000L);//intentional delay
        System.out.println("getAllEmployee -- completed");
        return CompletableFuture.completedFuture(employeeList);
    }

}
