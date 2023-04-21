package com.optima.registrationservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class EmployeeRequestDto {

    private String name;
    private String surname;
    private byte age;
    private UUID identityCode;

}
