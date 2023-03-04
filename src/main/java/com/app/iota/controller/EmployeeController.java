package com.app.iota.controller;

import com.app.iota.dto.request.EmployeeDto;
import com.app.iota.dto.request.EmployeeUpdateDto;
import com.app.iota.entity.Employee;
import com.app.iota.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Validated EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Validated EmployeeUpdateDto employeeUpdateDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeUpdateDto));
    }

}
