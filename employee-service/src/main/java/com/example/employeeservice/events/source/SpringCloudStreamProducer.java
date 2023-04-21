package com.example.employeeservice.events.source;

import com.example.employeeservice.model.dto.EmployeeRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringCloudStreamProducer {
    private Source source;

    @Autowired
    public SpringCloudStreamProducer(Source source) {
        this.source = source;
    }

    // TODO: 30.03.2023 add service layer here!
    public void sentEmployeeRegistrationRequest(EmployeeRequestDto request) {
        log.info("sending request to kafka with identityCode: {} ", request.getIdentityCode());
        EmployeeRequestDto employeeRequestDto = EmployeeRequestDto
                .builder()
                .age(request.getAge())
                .name(request.getName())
                .surname(request.getSurname())
                .identityCode(request.getIdentityCode())
                .build();
        source.output().send(MessageBuilder.withPayload(employeeRequestDto).build());
    }

}
