package com.exercise.exchangepay.controllers;

import com.exercise.exchangepay.configs.TestSecurityConfig;
import com.exercise.exchangepay.dtos.BillDTO;
import com.exercise.exchangepay.dtos.BillStatementDTO;
import com.exercise.exchangepay.services.BillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(TestSecurityConfig.class)
@WebMvcTest(BillController.class)
public class BillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillService billService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void shouldReturnBillSummaryModelFromUsdToEur() throws Exception {
        BillDTO billDTO = readBillFromJson("src/test/resources/data/bill.json");

        BillStatementDTO expectedResponse = new BillStatementDTO(
                "USD",
                BigDecimal.valueOf(86.78),
                BigDecimal.valueOf(26.04),
                BigDecimal.valueOf(60.75)
        );

        Mockito.when(billService.calculateBill(Mockito.any(BillDTO.class)))
                .thenReturn(expectedResponse);

        mockMvc.perform(post("/api/bill/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(billDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalAmount").value(86.78))
                .andExpect(jsonPath("$.discountApplied").value(26.04))
                .andExpect(jsonPath("$.finalAmount").value(60.75))
                .andExpect(jsonPath("$.currency").value("USD"));
    }

    private BillDTO readBillFromJson(String filePath) throws Exception {
        File file = new File(filePath);
        return objectMapper.readValue(file, BillDTO.class);
    }

}
