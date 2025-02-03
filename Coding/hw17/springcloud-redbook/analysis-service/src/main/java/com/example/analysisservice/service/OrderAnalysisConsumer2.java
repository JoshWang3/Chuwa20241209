package com.example.analysisservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderAnalysisConsumer2 {
    private static final Logger logger = LoggerFactory.getLogger(OrderAnalysisConsumer2.class);

    private final String consumerGroupId = "order-consumer-B";
    @Value("${kafka.topic.name}")
    private String topic;

    @KafkaListener(id = "consumer-B1", topics = "${kafka.topic.name}", groupId = "order-consumer-B")
    public void orderAnalysisConsumer1(String message) throws InterruptedException {
        Thread.sleep(10000);
        logger.info("ConsumerGroup-B, Consumer-B1 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }

    @KafkaListener(id = "consumer-B2", topics = "${kafka.topic.name}", groupId = "order-consumer-B")
    public void orderAnalysisConsumer2(String message) throws InterruptedException {
        Thread.sleep(10000);
        logger.info("ConsumerGroup-B, Consumer-B2 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }
}
