package com.optima.registrationservice.listener;

import com.optima.registrationservice.model.dto.EmployeeRequestDto;
import com.optima.registrationservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@RequiredArgsConstructor
public class RegistrationRequestListener {

    private final EmployeeService employeeService;

    @StreamListener(Sink.INPUT)
    public void requestReceiver(EmployeeRequestDto requestDto) {
        log.info("received request with identity code :{}", requestDto.getIdentityCode());
        employeeService.createEmployee(requestDto);
    }
}
