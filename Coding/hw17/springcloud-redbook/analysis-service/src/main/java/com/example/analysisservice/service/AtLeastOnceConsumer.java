package com.example.analysisservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class AtLeastOnceConsumer {
    private final Logger logger = LoggerFactory.getLogger(AtLeastOnceConsumer.class);

    @KafkaListener(groupId = "at-least-once-group", topics = "${kafka.topic.name}")
    public void consume(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
        try {
            logger.info("At Least Once - Received message: {} | Partition: {} | Offset: {}", record.value(), record.partition(), record.offset());
        } finally {
            // manual commit offset
            acknowledgment.acknowledge();
        }
    }
}
