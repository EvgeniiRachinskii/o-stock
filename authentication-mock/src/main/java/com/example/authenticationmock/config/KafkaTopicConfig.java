package com.example.authenticationmock.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic userTopicBuilder() {
        return TopicBuilder
                .name("unregisteredUsers")
                .config(TopicConfig.RETENTION_MS_CONFIG,"30000")
                .build();
    }
}