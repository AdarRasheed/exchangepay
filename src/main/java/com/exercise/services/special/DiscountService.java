package com.exercise.services.special;

import com.exercise.domains.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DiscountService {

    public BigDecimal calculateTotalDiscount(Bill bill) {
        //Todo: discount calculations here
        return BigDecimal.ZERO;
    }

}
