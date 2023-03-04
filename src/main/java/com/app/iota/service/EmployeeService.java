package com.app.iota.service;

import com.app.iota.dto.request.EmployeeDto;
import com.app.iota.dto.request.EmployeeUpdateDto;
import com.app.iota.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(EmployeeUpdateDto employeeUpdateDto);
}
