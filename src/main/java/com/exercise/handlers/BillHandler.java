package com.exercise.handlers;

import com.exercise.dtos.BillDTO;
import com.exercise.dtos.BillResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BillHandler {

    public BillResponseDTO calculateBill(BillDTO billDTO) {
        // Todo: bill calculations implementation
        return null;
    }

}
