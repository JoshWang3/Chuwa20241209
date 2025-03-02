package com.chuwa.demo.controller;

import com.chuwa.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public String publishMessage(@RequestParam("key") String key, @RequestParam("message") String message) {
        kafkaProducerService.sendMessage(key, message);
        return "Message published successfully";
    }

    @PostMapping("/batchpublish")
    public String batchPublishMessage() {
        for (int i = 1; i <= 20; i++) {
            kafkaProducerService.sendMessage("key" + i, "message" + i);
        }

        return "Message batch published successfully";
    }
}
