package com.example.authenticationmock.config;

import com.example.authenticationmock.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
@Slf4j
public class CustomProducerListener implements ProducerListener<String, User> {
    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("Successfully moved unregistered user to producer record topic : " + producerRecord.topic()
                + "producerRecord key" + producerRecord.key() + "producerRecord partition" + producerRecord.partition()
                + "record metadata topic" + recordMetadata.topic() + "record metadata partition" + recordMetadata.partition()
                + "record metadata offset" + recordMetadata.offset());
    }

    @Override
    public void onError(ProducerRecord producerRecord, RecordMetadata recordMetadata, Exception exception) {
        log.error("an error occurred" + producerRecord.topic() + producerRecord.topic()
                + "producerRecord key" + producerRecord.key() + "producerRecord partition" + producerRecord.partition() + exception.getMessage()
        );
    }
}
