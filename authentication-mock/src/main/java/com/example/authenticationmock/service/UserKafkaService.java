package com.example.authenticationmock.service;



import com.example.authenticationmock.model.dto.UserRequestDto;

public interface UserKafkaService {
    String moveToUnregistered(UserRequestDto userRequestDto);
}
