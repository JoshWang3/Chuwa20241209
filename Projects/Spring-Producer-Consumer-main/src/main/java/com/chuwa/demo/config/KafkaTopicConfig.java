package com.chuwa.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.name}")
    private String topic;

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(topic, 5, (short) 3);
    }
}
