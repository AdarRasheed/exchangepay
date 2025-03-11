package com.exercise.exchangepay.services.discount;

import com.exercise.exchangepay.domains.Bill;
import com.exercise.exchangepay.domains.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FlatDiscount implements DiscountStrategy {

    @Value("${discount.flat}")
    private BigDecimal discountPercentage;

    @Override
    public BigDecimal calculate(Bill bill) {
        BigDecimal totalBill = bill.getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal discountAmount = BigDecimal.valueOf(Math.floor(totalBill.doubleValue() / 100)).multiply(discountPercentage);

        return discountAmount.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    }

}
