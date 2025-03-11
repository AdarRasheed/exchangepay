package com.exercise.exchangepay.controllers;

import com.exercise.exchangepay.dtos.BillDTO;
import com.exercise.exchangepay.dtos.BillStatementDTO;
import com.exercise.exchangepay.services.BillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/bill"))
@Tag(name = "Bill Controller", description = "Endpoints for Bill Calculations")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(value = "/calculate")
    @Operation(
            summary = "Calculate Bill",
            description = "Calculates the bill based on provided details and returns the final statement.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully calculated bill"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    public ResponseEntity<BillStatementDTO> calculateBill(@RequestBody BillDTO billDTO) {
        return ResponseEntity.ok(
                billService.calculateBill(billDTO)
        );
    }

}
