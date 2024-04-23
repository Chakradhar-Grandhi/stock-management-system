package com.stockmanagement.controller;

import com.stockmanagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/price")
    public ResponseEntity<Double> getStockPrice(@RequestParam String symbol) {
        Double stockPrice = stockService.getStockPrice(symbol);
        return ResponseEntity.ok(stockPrice);
    }
}
