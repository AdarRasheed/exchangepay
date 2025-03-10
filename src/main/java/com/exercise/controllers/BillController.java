package com.exercise.controllers;

import com.exercise.dtos.BillDTO;
import com.exercise.dtos.BillStatementDTO;
import com.exercise.services.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/bill"))
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(value = "/calculate")
    public ResponseEntity<BillStatementDTO> calculateBill(@RequestBody BillDTO billDTO) {
        return ResponseEntity.ok(
                billService.calculateBill(billDTO)
        );
    }

}
