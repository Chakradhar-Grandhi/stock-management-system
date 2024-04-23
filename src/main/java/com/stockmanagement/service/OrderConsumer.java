package com.stockmanagement.service;

import com.stockmanagement.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void consumeOrder(Order order) {
        // Process the order (e.g., check stock price and execute the order)
        orderService.executeOrder(order);
    }
}
