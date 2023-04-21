package com.optima.registrationservice.service.impl;

import com.optima.registrationservice.mapper.EmployeeMapper;
import com.optima.registrationservice.model.dto.EmployeeRequestDto;
import com.optima.registrationservice.model.entity.Employee;
import com.optima.registrationservice.repository.EmployeeRepository;
import com.optima.registrationservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.optima.registrationservice.mapper.EmployeeMapper.toEntity;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = toEntity(employeeRequestDto);
        employeeRepository.save(employee);
        return "Successfully saved employee to database";
    }
}
