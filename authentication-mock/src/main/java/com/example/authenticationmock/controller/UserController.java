package com.example.authenticationmock.controller;

import com.example.authenticationmock.model.dto.UserRequestDto;
import com.example.authenticationmock.service.UserKafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v0/user")
@RequiredArgsConstructor
public class UserController {

    private final UserKafkaService userKafkaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String checkUser(@RequestBody UserRequestDto userRequestDto) {
        return userKafkaService.moveToUnregistered(userRequestDto);
    }


}
