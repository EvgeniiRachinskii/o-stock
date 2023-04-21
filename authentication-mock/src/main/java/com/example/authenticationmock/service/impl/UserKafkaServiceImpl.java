package com.example.authenticationmock.service.impl;


import com.example.authenticationmock.model.User;
import com.example.authenticationmock.model.dto.UserRequestDto;
import com.example.authenticationmock.repository.UserRepository;
import com.example.authenticationmock.service.UserKafkaService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.authenticationmock.mapper.UserMapper.toEntity;


@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserKafkaServiceImpl implements UserKafkaService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, User> kafkaTemplate;


    @Override
    @SneakyThrows
    public String moveToUnregistered(UserRequestDto requestDto) {
        User user = toEntity(requestDto);
        if (user.getLevel() == 0) {
            kafkaTemplate.send("unregisteredUsers", user);
            return "unregistered user was moved to kafka topic";
        }
        userRepository.save(user);
        return "User saved to db";
    }


}
