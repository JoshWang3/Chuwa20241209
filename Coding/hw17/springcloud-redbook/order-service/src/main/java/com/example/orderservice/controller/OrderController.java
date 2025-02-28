package com.example.orderservice.controller;

import com.example.orderservice.payload.OrderDTO;
import com.example.orderservice.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final KafkaProducerService kafkaProducerService;

    public OrderController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getUserById(@PathVariable Long id) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerId("1");
        orderDTO.setOrderId("1");
        orderDTO.setProductDescription("fake");
        orderDTO.setProductPrice("12.0");
        orderDTO.setProductName("fake");
        orderDTO.setProductQuantity("2");
        orderDTO.setProductId("fakeProduct");

        String message = String.format("{\"orderId\": \"%s\", \"userId\": \"%s\", \"productId\": \"%s\"}",
                orderDTO.getOrderId(), orderDTO.getCustomerId(), orderDTO.getProductId());

        kafkaProducerService.sendMessage(orderDTO.getCustomerId(), message);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @GetMapping("/order-mocking")
    public ResponseEntity<String> mockOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerId(UUID.randomUUID().toString());
        orderDTO.setOrderId(Math.random() * 10 + "");
        orderDTO.setProductDescription("fake product");
        orderDTO.setProductPrice(Math.random() * 100 + "");
        orderDTO.setProductName("fake product");
        orderDTO.setProductQuantity(Math.random() * 10 + "");
        orderDTO.setProductId(UUID.randomUUID().toString());

        String message = String.format("{\"orderId\": \"%s\", \"userId\": \"%s\", \"productId\": \"%s\"}",
                orderDTO.getOrderId(), orderDTO.getCustomerId(), orderDTO.getProductId());

        kafkaProducerService.sendMessageInTransaction(orderDTO.getCustomerId(), message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
