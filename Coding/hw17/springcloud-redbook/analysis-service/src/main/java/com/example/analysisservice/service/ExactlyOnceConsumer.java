package com.example.analysisservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExactlyOnceConsumer {
    private final Logger logger = LoggerFactory.getLogger(ExactlyOnceConsumer.class);

    @KafkaListener(groupId = "exactly-once-group", topics = "${kafka.topic.name}")
    public void consume(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
        try {
            logger.info("Exactly Once - Received message: {} | Partition: {} | Offset: {}", record.value(), record.partition(), record.offset());
        } finally {
            // manual commit offset
            acknowledgment.acknowledge();
        }
    }
}

