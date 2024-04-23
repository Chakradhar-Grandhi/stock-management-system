package com.stockmanagement.service;

import com.stockmanagement.dto.OrderRequest;
import com.stockmanagement.entity.Order;
import com.stockmanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StockService stockService;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Order placeOrder(OrderRequest orderRequest) {
        // Fetch the current market price for the stock symbol
        Double currentPrice = stockService.getStockPrice(orderRequest.getSymbol());

        // Create a new order and set its properties
        Order order = new Order();
        order.setSymbol(orderRequest.getSymbol());
        order.setType(orderRequest.getOrderType());  // "BUY" or "SELL"
        order.setQuantity(orderRequest.getQuantity());
        order.setPrice(currentPrice);  // Set the current market price as the order price
        order.setStatus("PENDING");

        // Save order in the database
        Order savedOrder = orderRepository.save(order);

        // Send order to Kafka for processing
        kafkaTemplate.send("orders", savedOrder);

        return savedOrder;
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void executeOrder(Order order) {
        Double currentPrice = stockService.getStockPrice(order.getSymbol());

        if (currentPrice != null) {
            if ("BUY".equals(order.getType()) && order.getPrice() >= currentPrice) {
                order.setStatus("EXECUTED");
            } else if ("SELL".equals(order.getType()) && order.getPrice() <= currentPrice) {
                order.setStatus("EXECUTED");
            } else {
                order.setStatus("PENDING");
            }
        } else {
            order.setStatus("FAILED");
        }

        // Update order status in the database
        orderRepository.save(order);
    }
}
