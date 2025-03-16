package com.example.KafkaConsumerService.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    // Consumer 1
    @KafkaListener(id = "consumer-1", topics = "my-topic")
    public void consume1(ConsumerRecord<String, String> record, Acknowledgment ack) {
        processMessage(record, "Consumer 1");
        ack.acknowledge(); // Manually commit the offset
    }

    // Consumer 2
    @KafkaListener(id = "consumer-2", topics = "my-topic")
    public void consume2(ConsumerRecord<String, String> record, Acknowledgment ack) {
        processMessage(record, "Consumer 2");
        ack.acknowledge(); // Manually commit the offset
    }

    // Consumer 3
    @KafkaListener(id = "consumer-3", topics = "my-topic")
    public void consume3(ConsumerRecord<String, String> record, Acknowledgment ack) {
        processMessage(record, "Consumer 3");
        ack.acknowledge(); // Manually commit the offset
    }

    private void processMessage(ConsumerRecord<String, String> record, String consumerId) {
        System.out.printf("%s received message: key = %s, value = %s, partition = %d, offset = %d%n",
                consumerId, record.key(), record.value(), record.partition(), record.offset());
    }
}