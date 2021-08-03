package com.employee.api.service;

import com.employee.api.model.Employee;

public interface EmpService extends CrudService<Employee, Long> {
    Employee findByLastName(Employee employee);
}
