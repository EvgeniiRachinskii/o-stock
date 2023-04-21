package com.optima.registrationservice.service;

import com.optima.registrationservice.model.dto.EmployeeRequestDto;
import com.optima.registrationservice.model.entity.Employee;

public interface EmployeeService {
    String createEmployee(EmployeeRequestDto employeeRequestDto);
}
