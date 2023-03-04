package com.app.iota.service.impl;

import com.app.iota.dto.request.EmployeeDto;
import com.app.iota.dto.request.EmployeeUpdateDto;
import com.app.iota.entity.Employee;
import com.app.iota.repository.EmployeeRepository;
import com.app.iota.service.EmployeeService;
import com.app.iota.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        if (!ValidationUtils.phoneNumberValidation(employeeDto.getMobile())) {
            throw new IllegalArgumentException("Mobile's format is not properly!");
        } else {
            Employee employee = Employee.builder()
                    .firstName(employeeDto.getFirstName())
                    .lastName(employeeDto.getLastName())
                    .mobile(employeeDto.getMobile())
                    .email(employeeDto.getEmail()).build();
            return employeeRepository.save(employee);
        }
    }

    @Override
    public Employee updateEmployee(EmployeeUpdateDto employeeUpdateDto) {
        Optional<Employee> oldEmployee = employeeRepository.findById(employeeUpdateDto.getId());
        if (oldEmployee.isPresent()) {
            Employee updatedEmployee = oldEmployee.get();
            updatedEmployee.setFirstName(employeeUpdateDto.getFirstName());
            updatedEmployee.setEmail(employeeUpdateDto.getEmail());
            updatedEmployee.setMobile(employeeUpdateDto.getMobile());
            updatedEmployee.setLastName(employeeUpdateDto.getLastName());
            return employeeRepository.save(updatedEmployee);
        } else {
            throw new NullPointerException("Employee Not Found");
        }
    }
    public void deleteById(Long id){
        employeeRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("This id doesn't belong the any employee!")
        );
        employeeRepository.deleteById(id);
    }
}
