package com.exercise.exchangepay.services;

import com.exercise.exchangepay.dtos.ExchangeRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
@Slf4j
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Value("${exchange.api_url}")
    private String apiUrl;
    @Value("${exchange.api_key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public CurrencyExchangeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {

        String url = UriComponentsBuilder.fromUriString(apiUrl)
                .buildAndExpand(apiKey, fromCurrency)
                .toUriString();

        try {
            ExchangeRateDTO response = restTemplate.getForObject(url, ExchangeRateDTO.class);

            if (response == null || !"success".equals(response.getResult())) {
                throw new RuntimeException("Failed to fetch exchange rates from API");
            }

            BigDecimal targetRate = response.getConversionRates().get(toCurrency);
            if (targetRate == null) {
                throw new IllegalArgumentException("Target currency rate not available");
            }
            return targetRate;

        } catch (Exception e) {
//            log.error(e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred", e);
        }

    }

}
