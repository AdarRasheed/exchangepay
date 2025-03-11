package com.exercise.exchangepay.services.discount;

import com.exercise.exchangepay.domains.Bill;
import com.exercise.exchangepay.domains.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class EmployeeDiscount implements DiscountStrategy {

    @Value("${discount.employee}")
    private String discountPercentage;

    public BigDecimal calculate(Bill bill) {
        if (bill.getUser().isEmployee()) {
            BigDecimal totalDiscountableAmount = bill.getItems().stream()
                    .filter(item -> !item.isGrocery())
                    .map(Item::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return totalDiscountableAmount.multiply(new BigDecimal(discountPercentage))
                    .divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
        }
        return BigDecimal.ZERO.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
    }
}

