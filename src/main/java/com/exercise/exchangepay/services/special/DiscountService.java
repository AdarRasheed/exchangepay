package com.exercise.exchangepay.services.special;

import com.exercise.exchangepay.domains.Bill;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountService {

    public BigDecimal calculateTotalDiscount(Bill bill) {
        //Todo: discount calculations here
        return BigDecimal.ZERO;
    }

}
