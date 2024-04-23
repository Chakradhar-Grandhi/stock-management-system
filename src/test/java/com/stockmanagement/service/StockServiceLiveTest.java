package com.stockmanagement.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StockServiceLiveTest {

    @Autowired
    private StockService stockService;

    @Test
    public void testGetStockPriceLive() {
        // Choose a stock symbol to test
        String symbol = "AAPL";

        // Call the live API and get the response
        Double price = stockService.getStockPrice(symbol);

        // Check that the price is not null (indicating a successful API call)
        assertNotNull(price, "The API call returned null, which indicates a failure.");

        // Further assertions can be made depending on the expected behavior
        assertTrue(price > 0, "The stock price should be greater than zero.");
    }
}
