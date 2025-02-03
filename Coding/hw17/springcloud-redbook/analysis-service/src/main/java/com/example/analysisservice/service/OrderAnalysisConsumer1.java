package com.example.analysisservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderAnalysisConsumer1 {
    private static final Logger logger = LoggerFactory.getLogger(OrderAnalysisConsumer1.class);

    private final String consumerGroupId = "order-consumer-A";
    @Value("${kafka.topic.name}")
    private String topic;

    @KafkaListener(id = "consumer-A1", topics = "${kafka.topic.name}", groupId = "order-consumer-A")
    public void orderAnalysisConsumer1(String message) {
        logger.info("ConsumerGroup-A, Consumer-A1 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }

    @KafkaListener(id = "consumer-A2", topics = "${kafka.topic.name}", groupId = "order-consumer-A")
    public void orderAnalysisConsumer2(String message) {
        logger.info("ConsumerGroup-A, Consumer-A2 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }

    @KafkaListener(id = "consumer-A3", topics = "${kafka.topic.name}", groupId = "order-consumer-A")
    public void orderAnalysisConsumer3(String message) {
        logger.info("ConsumerGroup-A, Consumer-A3 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }

    @KafkaListener(id = "consumer-A4", topics = "${kafka.topic.name}", groupId = "order-consumer-A")
    public void orderAnalysisConsumer4(String message) {
        logger.info("ConsumerGroup-A, Consumer-A4 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }

    @KafkaListener(id = "consumer-A5", topics = "${kafka.topic.name}", groupId = "order-consumer-A")
    public void orderAnalysisConsumer5(String message) {
        logger.info("ConsumerGroup-A, Consumer-A5 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }
}
