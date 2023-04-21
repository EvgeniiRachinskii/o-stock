package com.example.authenticationmock.service;

import com.example.authenticationmock.model.dto.UserRequestDto;


public interface UserService {
    String createUser(UserRequestDto userRequestDto);
}
