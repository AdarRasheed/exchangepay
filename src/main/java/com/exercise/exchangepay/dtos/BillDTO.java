package com.exercise.exchangepay.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "Data Transfer Object for Bill Calculation")
public class BillDTO {

    @Schema(description = "Unique identifier of the user", example = "12345")
    private String userId;
    @Schema(description = "Type of user (e.g., OTHERS, AFFILIATE, EMPLOYEE)", example = "EMPLOYEE")
    private String userType;
    @Schema(description = "List of items included in the bill")
    private List<ItemDTO> itemDTOs;
    @Schema(description = "Date when the customer started using the service", example = "2019-06-15")
    private LocalDate customerSince;
    @Schema(description = "Currency in which the bill was originally calculated", example = "USD")
    private String originalCurrency;
    @Schema(description = "Currency in which the final bill is to be presented", example = "EUR")
    private String targetCurrency;

    public BillDTO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<ItemDTO> getItemDTOs() {
        return itemDTOs;
    }

    public void setItemDTOs(List<ItemDTO> itemDTOs) {
        this.itemDTOs = itemDTOs;
    }

    public LocalDate getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(LocalDate customerSince) {
        this.customerSince = customerSince;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    @Override
    public String toString() {
        return "BillDTO{" +
                "userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", itemDTOs=" + itemDTOs +
                ", customerSince=" + customerSince +
                ", originalCurrency='" + originalCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                '}';
    }
}
