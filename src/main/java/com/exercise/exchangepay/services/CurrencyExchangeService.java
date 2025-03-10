package com.exercise.exchangepay.services;

import java.math.BigDecimal;

public interface CurrencyExchangeService {

    BigDecimal getExchangeRate(String fromCurrency, String toCurrency);

}
