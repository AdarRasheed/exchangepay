package com.exercise.controllers;

import com.exercise.dtos.BillDTO;
import com.exercise.dtos.BillResponseDTO;
import com.exercise.handlers.BillHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/api/bill"))
public class BillController {

    private final BillHandler billHandler;

    @PostMapping(value = "/calculate")
    public ResponseEntity<BillResponseDTO> calculateBill(@RequestBody BillDTO billDTO) {
        return ResponseEntity.ok(
                billHandler.calculateBill(billDTO)
        );
    }

}
