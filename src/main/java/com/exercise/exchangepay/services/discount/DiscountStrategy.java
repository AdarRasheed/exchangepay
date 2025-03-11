package com.exercise.exchangepay.services.discount;

import com.exercise.exchangepay.domains.Bill;

import java.math.BigDecimal;

public interface DiscountStrategy {

    BigDecimal calculate(Bill bill);

}
