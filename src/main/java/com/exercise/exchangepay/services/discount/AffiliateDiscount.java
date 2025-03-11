package com.exercise.exchangepay.services.discount;

import com.exercise.exchangepay.domains.Bill;
import com.exercise.exchangepay.domains.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AffiliateDiscount implements DiscountStrategy {

    @Value("${discount.affiliate}")
    private BigDecimal discountPercentage;

    @Override
    public BigDecimal calculate(Bill bill) {
        if (bill.getUser().isAffiliate()) {
            BigDecimal totalDiscountable = bill.getItems().stream()
                    .filter(item -> !item.isGrocery())
                    .map(Item::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            return totalDiscountable.multiply(discountPercentage).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
        }
        return BigDecimal.ZERO.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    }
}
