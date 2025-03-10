package com.exercise.transformers;

import com.exercise.domains.BillStatement;
import com.exercise.dtos.BillStatementDTO;
import org.springframework.stereotype.Component;

@Component
public class BillStatementTransformer implements Transformer<BillStatementDTO, BillStatement> {

    @Override
    public BillStatement toDomain(BillStatementDTO billStatementDTO) {
        throw new UnsupportedOperationException("No implementation required yet");
    }

    @Override
    public BillStatementDTO toDTO(BillStatement billStatement) {
        return BillStatementDTO.builder()
                .currency(billStatement.getCurrency())
                .totalAmount(billStatement.getTotalAmount())
                .finalAmount(billStatement.getFinalAmount())
                .discountApplied(billStatement.getDiscountApplied())
                .build();
    }

}
