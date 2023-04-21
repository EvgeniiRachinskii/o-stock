package com.example.authenticationmock.mapper;

import com.example.authenticationmock.model.User;
import com.example.authenticationmock.model.dto.UserRequestDto;


public class UserMapper {
    public UserMapper() {
    }
    public static User toEntity(UserRequestDto userRequestDto) {
        return User
                .builder()
                .name(userRequestDto.getName())
                .level(userRequestDto.getLevel())
                .age(userRequestDto.getAge())
                .build();
    }
}
