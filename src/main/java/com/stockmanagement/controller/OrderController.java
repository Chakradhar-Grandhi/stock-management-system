package com.stockmanagement.controller;

import com.stockmanagement.dto.OrderRequest;
import com.stockmanagement.service.OrderService;
import com.stockmanagement.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/buy")
    public ResponseEntity<String> placeBuyOrder(@RequestBody OrderRequest orderRequest) {
        orderRequest.setOrderType("BUY");
        Order order = orderService.placeOrder(orderRequest);
        return ResponseEntity.ok("Buy order placed successfully with ID: " + order.getId());
    }

    @PostMapping("/sell")
    public ResponseEntity<String> placeSellOrder(@RequestBody OrderRequest orderRequest) {
        orderRequest.setOrderType("SELL");
        Order order = orderService.placeOrder(orderRequest);
        return ResponseEntity.ok("Sell order placed successfully with ID: " + order.getId());
    }
}
