package com.exercise.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Value("${exchange.api_url}")
    private String apiUrl;
    @Value("${exchange.api_key}")
    private String apiKey;

    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        //Todo: implement exhcange rates fetching mechanism
        return BigDecimal.ONE;
    }

}
