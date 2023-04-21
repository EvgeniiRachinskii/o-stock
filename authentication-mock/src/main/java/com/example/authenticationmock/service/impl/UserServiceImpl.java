package com.example.authenticationmock.service.impl;

import com.example.authenticationmock.model.User;
import com.example.authenticationmock.model.dto.UserRequestDto;
import com.example.authenticationmock.repository.UserRepository;
import com.example.authenticationmock.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.example.authenticationmock.mapper.UserMapper.toEntity;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository employeeRepository;

    @Override
    public String createUser(UserRequestDto userRequestDto) {
        User user = toEntity(userRequestDto);
        employeeRepository.save(user);
        return "Successfully saved user to database";
    }
}
