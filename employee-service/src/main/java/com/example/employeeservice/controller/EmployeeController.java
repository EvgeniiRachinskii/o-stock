package com.example.employeeservice.controller;

import com.example.employeeservice.events.source.SpringCloudStreamProducer;
import com.example.employeeservice.model.dto.EmployeeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/request")
public class EmployeeController {

    private final SpringCloudStreamProducer springCloudStreamProducer;

    @PostMapping
    public ResponseEntity<String> sendRequest(@RequestBody EmployeeRequestDto requestDto) {
        springCloudStreamProducer.sentEmployeeRegistrationRequest(requestDto);
        return ResponseEntity.ok("Successfully sent a request : " + requestDto.getIdentityCode());
    }
}
