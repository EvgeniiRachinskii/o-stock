package com.optima.registrationservice.mapper;

import com.optima.registrationservice.model.dto.EmployeeRequestDto;
import com.optima.registrationservice.model.entity.Employee;

public class EmployeeMapper {
    public EmployeeMapper() {
    }
    public static Employee toEntity(EmployeeRequestDto employeeRequestDto) {
        return Employee
                .builder()
                .name(employeeRequestDto.getName())
                .surname(employeeRequestDto.getSurname())
                .identityCode(employeeRequestDto.getIdentityCode())
                .age(employeeRequestDto.getAge())
                .build();
    }
}
