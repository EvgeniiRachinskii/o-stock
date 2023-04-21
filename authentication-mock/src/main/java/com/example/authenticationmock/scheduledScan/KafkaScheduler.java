package com.example.authenticationmock.scheduledScan;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.example.authenticationmock.model.User;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
//@Slf4j
//public class KafkaScheduler {
//
//    private final Consumer<String, User> consumer;
//
//
//    public KafkaScheduler() {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        this.consumer = new KafkaConsumer<>(props);
//
//    }
//
//    @Scheduled(fixedDelay = 2000)
//    public void start() {
//        consumer.subscribe(Collections.singletonList("unregisteredUsers"));
//        ConsumerRecords<String, User> records = consumer.poll(Duration.ofSeconds(1));
//        if (!records.isEmpty()) {
//            log.info("Found " + records.count() + " messages");
//        }
//
//    }
//
//}
