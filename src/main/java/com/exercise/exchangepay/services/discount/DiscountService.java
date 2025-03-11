package com.exercise.exchangepay.services.discount;

import com.exercise.exchangepay.domains.Bill;
import com.exercise.exchangepay.services.discount.DiscountStrategy;
import com.exercise.exchangepay.services.discount.FlatDiscount;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DiscountService {

    private final List<DiscountStrategy> discountStrategies;
    private final FlatDiscount flatDiscount;

    public DiscountService(List<DiscountStrategy> discountStrategies, FlatDiscount flatDiscount) {
        this.discountStrategies = discountStrategies;
        this.flatDiscount = flatDiscount;
    }

    public BigDecimal calculateTotalDiscount(Bill bill) {
        BigDecimal bestPercentageDiscount = discountStrategies.stream()
                .map(discount -> discount.calculate(bill))
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        BigDecimal flatDiscountAmount = flatDiscount.calculate(bill);
        return bestPercentageDiscount.add(flatDiscountAmount);
    }

}
