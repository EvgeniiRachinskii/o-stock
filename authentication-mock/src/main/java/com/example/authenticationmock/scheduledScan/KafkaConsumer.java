package com.example.authenticationmock.scheduledScan;

import com.example.authenticationmock.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutionException;


@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumer {

    @Autowired
    private KafkaListenerEndpointRegistry registry;
    private final ObjectMapper objectMapper;

    @KafkaListener(id = "users", topics = "unregisteredUsers", groupId = "zeroLevelUsers", autoStartup = "false")
    public void sentNotificationToUnregisteredUser(String data) throws JsonProcessingException {
        User user = objectMapper.readValue(data, User.class);
        log.info("Hello dear : " + user.getName() + " you saw this message because your registration is unfinished," +
                " please complete registration to get access to our application");
    }

    @Scheduled(cron = "0,15,30,45 * * * * ?")
    public void start() {
        registry.getListenerContainer("users").start();
    }


    @Scheduled(cron = "20,40,0 * * * * ?")
    public void stop() {
        if (registry.getListenerContainer("users").isRunning()) {
            registry.stop();
        }
    }
}
