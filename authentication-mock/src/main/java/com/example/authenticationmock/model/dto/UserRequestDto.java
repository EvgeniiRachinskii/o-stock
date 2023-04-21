package com.example.authenticationmock.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class UserRequestDto {

    private String name;
    private byte age;
    private byte level;

}
