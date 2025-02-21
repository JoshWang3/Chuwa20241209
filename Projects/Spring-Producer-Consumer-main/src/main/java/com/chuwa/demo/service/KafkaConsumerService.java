package com.chuwa.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


@Service
public class KafkaConsumerService {
    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;
    @Value("${kafka.topic.name}")
    private String topic;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}", concurrency = "1")
    public void listenGroupFoo1(String message) {
        System.out.println("Received message: " + message + " from group: " + consumerGroupId + " with topic: " + topic);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "consumer_group_2", concurrency = "2")
    public void listenGroupFoo2(String message) {
        System.out.println("Received message: " + message + " from group: " + consumerGroupId + " with topic: " + topic);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "consumer_group_3", concurrency = "3")
    public void listenGroupFoo3(String message) {
        System.out.println("Received message: " + message + " from group: " + consumerGroupId + " with topic: " + topic);
    }

}
