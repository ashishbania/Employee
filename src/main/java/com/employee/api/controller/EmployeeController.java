package com.employee.api.controller;

import com.employee.api.model.Employee;
import com.employee.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public @ResponseBody List<Employee> getAllEmployees() throws InterruptedException, ExecutionException {
         List<Employee> empList = (List<Employee>) employeeService.getAllEmployee();
         List<Employee> empListLesserThan30 = employeeService.getEmpLesserAge(32L);

         //Wait until they are all done
        return empList;
//        return CompletableFuture.allOf(empList, empListLesserThan30).join();
//        System.out.println(o);
//        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long employeeId ){
//        System.out.println("Employee found by "+employeeId);
        Optional<Employee> empById = employeeService.getEmployeeById(employeeId);
        if (empById == null){
            throw new IllegalStateException("Employee doesnt exist");
        }
        else
            return empById;
    }
//    @GetMapping("/findLesserAge/{age}")
//    public List<Employee> getEmployeeLesser30(@PathVariable("age") Long age) throws InterruptedException, ExecutionException{
//        return employeeService.getEmpLesserAge(age);
//    }
    @PostMapping()
    public String saveEmployee(@RequestBody Employee employee){
        System.out.println("Employee has been added");
        return "Employee has been added" + employee.toString();
    }

    @DeleteMapping("/{id}")
    public String removeEmployee(@PathVariable("id") Long IdToBeDeleted){
        System.out.println("Employee has been removed with "+IdToBeDeleted);
        return "Employee has been removed"+IdToBeDeleted;
    }
}
