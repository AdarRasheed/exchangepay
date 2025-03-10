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
                .totalAmount(statement.getTotalAmount().multiply(exchangeRate)
                        .setScale(2))
                .discountApplied(statement.getDiscountApplied().multiply(exchangeRate)
                        .setScale(2))
                .finalAmount(statement.getFinalAmount().multiply(exchangeRate)
                        .setScale(2))
                .currency(targetCurrency)
                .build();
    }

}
