package com.example.orderservice.controller;

import com.example.orderservice.payload.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getUserById(@PathVariable Long id) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerId("1");
        orderDTO.setOrderId("1");
        orderDTO.setProductDescription("fake");
        orderDTO.setProductPrice("12.0");
        orderDTO.setProductName("fake");
        orderDTO.setProductQuantity("2");
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }
}
