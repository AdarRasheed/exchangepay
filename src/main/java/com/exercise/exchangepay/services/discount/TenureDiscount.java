package com.exercise.exchangepay.services.discount;

import com.exercise.exchangepay.domains.Bill;
import com.exercise.exchangepay.domains.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TenureDiscount implements DiscountStrategy {

    @Value("${discount.tenure}")
    private BigDecimal discountPercentage ;

    @Override
    public BigDecimal calculate(Bill bill) {
        if (bill.getUser().isRecurringCustomer()) {
            return bill.getItems().stream()
                    .filter(item -> !item.isGrocery())
                    .map(Item::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .multiply(discountPercentage);
        }
        return BigDecimal.ZERO;
    }
}
