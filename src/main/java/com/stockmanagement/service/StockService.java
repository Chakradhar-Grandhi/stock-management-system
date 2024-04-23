package com.stockmanagement.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;
@Service
public class StockService {

    private final RestTemplate restTemplate;

    @Value("${alphavantage.apikey}")
    private String apiKey;

    public StockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double getStockPrice(String symbol) {
        String url = String.format("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=%s&interval=1min&apikey=%s", symbol, apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return parsePrice(response.getBody());
    }

    private Double parsePrice(String response) {
        // Parse the JSON response and extract the stock price
        // For example, using JSONObject
        JSONObject jsonObject = new JSONObject(response);
        JSONObject timeSeries = jsonObject.getJSONObject("Time Series (1min)");
        String latestTime = timeSeries.keys().next();
        JSONObject latestData = timeSeries.getJSONObject(latestTime);
        return latestData.getDouble("4. close");
    }
}
