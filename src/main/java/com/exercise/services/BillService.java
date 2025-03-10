package com.exercise.services;

import com.exercise.domains.Bill;
import com.exercise.domains.BillStatement;
import com.exercise.dtos.BillDTO;
import com.exercise.dtos.BillStatementDTO;
import com.exercise.services.special.DiscountService;
import com.exercise.transformers.BillStatementTransformer;
import com.exercise.transformers.BillTransformer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BillService {

    private static final int SCALE = 2;
    private static final BigDecimal ONE = BigDecimal.ONE; // Used to force rounding

    private final BillTransformer billTransformer;
    private final BillStatementTransformer billStatementTransformer;

    private final DiscountService discountService;
    private final CurrencyExchangeService currencyExchangeService;

    public BillService(BillTransformer billTransformer, BillStatementTransformer billStatementTransformer,
                       DiscountService discountService, CurrencyExchangeService currencyExchangeService) {
        this.billTransformer = billTransformer;
        this.billStatementTransformer = billStatementTransformer;

        this.discountService = discountService;
        this.currencyExchangeService = currencyExchangeService;
    }

    public BillStatementDTO calculateBill(BillDTO billDTO) {
        Bill bill = billTransformer.toDomain(billDTO);
        BillStatement statement = bill.createStatement(discountService);
        BillStatement convertedStatement = createStatementByCurrency(billDTO.getTargetCurrency(), statement);
        return billStatementTransformer.toDTO(convertedStatement);
    }

    private BillStatement createStatementByCurrency(String targetCurrency, BillStatement statement){
        String originalCurrency = statement.getCurrency();
        BigDecimal exchangeRate = currencyExchangeService.getExchangeRate(originalCurrency, targetCurrency);
        return BillStatement.builder()
                .totalAmount(statement.getTotalAmount()
                        .multiply(exchangeRate)
                        .divide(ONE, SCALE, BigDecimal.ROUND_HALF_UP))
                .discountApplied(statement.getDiscountApplied()
                        .multiply(exchangeRate)
                        .divide(ONE, SCALE, BigDecimal.ROUND_HALF_UP))
                .finalAmount(statement.getFinalAmount()
                        .multiply(exchangeRate)
                        .divide(ONE, SCALE, BigDecimal.ROUND_HALF_UP))
                .currency(targetCurrency)
                .build();
    }

}
