package com.example.analysisservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class AtMostOnceConsumer {
    private final Logger logger = LoggerFactory.getLogger(AtMostOnceConsumer.class);

    @KafkaListener(groupId = "at-most-once-group", topics = "${kafka.topic.name}")
    public void consume(ConsumerRecord<String, String> record) {
        logger.info("At Most Once - Received message: {} | Partition: {} | Offset: {}", record.value(), record.partition(), record.offset());
    }
}
