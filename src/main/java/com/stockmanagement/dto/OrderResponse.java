package com.stockmanagement.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private String symbol;
    private String type;
    private int quantity;
    private double price;
    private String status;
}
