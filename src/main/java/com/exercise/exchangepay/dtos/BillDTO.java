package com.exercise.exchangepay.dtos;

import java.time.LocalDate;
import java.util.List;

public class BillDTO {

    private String userId;
    private String userType;
    private List<ItemDTO> itemDTOs;
    private LocalDate customerSince;
    private String originalCurrency;
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
