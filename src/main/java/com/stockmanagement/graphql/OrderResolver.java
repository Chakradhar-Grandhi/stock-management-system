package com.stockmanagement.graphql;

import com.stockmanagement.dto.OrderRequest;
import com.stockmanagement.entity.Order;
import com.stockmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderResolver {

    @Autowired
    private OrderService orderService;

    public Order placeOrder(OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    public Order getOrder(Long id) {
        return orderService.getOrder(id);
    }

    public List<Order> allOrders() {
        return orderService.getAllOrders();
    }
}
