package com.example.analysisservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderAnalysisConsumer3 {
    private static final Logger logger = LoggerFactory.getLogger(OrderAnalysisConsumer3.class);

    @Value("${kafka.topic.name}")
    private String topic;

    @KafkaListener(id = "consumer-C1", topics = "${kafka.topic.name}", groupId = "order-consumer-C")
    public void orderAnalysisConsumer1(String message) throws InterruptedException {
        String consumerGroupId = "order-consumer-C";
        Thread.sleep(20000);
        logger.info("ConsumerGroup-C, Consumer-C1 received message: {} from group: {} with topic: {}", message, consumerGroupId, topic);
    }
}
