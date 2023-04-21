package com.example.authenticationmock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@Slf4j
@SpringBootApplication
@EnableScheduling
public class AuthenticationMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationMockApplication.class, args);
    }

}
