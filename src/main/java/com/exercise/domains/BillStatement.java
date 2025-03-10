package com.exercise.domains;

import java.math.BigDecimal;


public class BillStatement {

    private final String currency;
    private final BigDecimal totalAmount;
    private final BigDecimal discountApplied;
    private final BigDecimal finalAmount;

    public BillStatement(String currency, BigDecimal totalAmount, BigDecimal discountApplied, BigDecimal finalAmount) {
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
        return "BillStatement{" +
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

        public BillStatement build() {
            return new BillStatement(currency, totalAmount, discountApplied, finalAmount);
        }
    }

}
