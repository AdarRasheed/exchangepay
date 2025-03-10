package com.exercise.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/bill"))
public class BillController {

    @PostMapping(value = "/calculate")
    public ResponseEntity<?> calculateBill() {
        return ResponseEntity.ok().build();
    }

}
