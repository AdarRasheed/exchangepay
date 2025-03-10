package com.exercise.exchangepay.dtos;

import java.math.BigDecimal;

public class BillStatementDTO {

    private String currency;
    private BigDecimal totalAmount;
    private BigDecimal discountApplied;
    private BigDecimal finalAmount;

    public BillStatementDTO(String currency, BigDecimal totalAmount, BigDecimal discountApplied, BigDecimal finalAmount) {
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.discountApplied = discountApplied;
        this.finalAmount = finalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getDiscountApplied() {
        return discountApplied;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    @Override
    public String toString() {
        return "BillStatementDTO{" +
                "currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", discountApplied=" + discountApplied +
                ", finalAmount=" + finalAmount +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String currency;
        private BigDecimal totalAmount;
        private BigDecimal discountApplied;
        private BigDecimal finalAmount;

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder discountApplied(BigDecimal discountApplied) {
            this.discountApplied = discountApplied;
            return this;
        }

        public Builder finalAmount(BigDecimal finalAmount) {
            this.finalAmount = finalAmount;
            return this;
        }

        public BillStatementDTO build() {
            return new BillStatementDTO(currency, totalAmount, discountApplied, finalAmount);
        }
    }
}
