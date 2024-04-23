package com.stockmanagement.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStockPrice_Success() {
        // Mock the response from the API
        String mockResponse = "{ \"Time Series (1min)\": { \"2024-08-01 15:59:00\": { \"4. close\": \"150.00\" }}}";
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(ResponseEntity.ok(mockResponse));

        // Call the method under test
        Double price = stockService.getStockPrice("IBM");

        // Verify the results
        assertNotNull(price);
        assertEquals(150.00, price);
    }

    @Test
    void testGetStockPrice_ApiError() {
        // Mock the response from the API
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenThrow(new RuntimeException("API Error"));

        // Call the method under test and expect an exception
        assertThrows(RuntimeException.class, () -> stockService.getStockPrice("IBM"));
    }
}
