package com.example.authenticationmock.config;

import com.example.authenticationmock.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.kafka.support.ProducerListener;

@Configuration
public class configurationListener {
    @Bean
    public ProducerListener producerListener() {
        return new CustomProducerListener();
    }
    @Bean
    @ConditionalOnMissingBean(ProducerListener.class)
    public ProducerListener<String, User> kafkaProducerListener() {
        return new LoggingProducerListener<>();
    }
}
