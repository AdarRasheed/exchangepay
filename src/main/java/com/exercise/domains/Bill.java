package com.exercise.domains;

import com.exercise.services.special.DiscountService;

import java.math.BigDecimal;
import java.util.List;

public class Bill {

    private final User user;
    private final List<Item> items;
    private final String currency;

    public Bill(User user, List<Item> items, String currency) {
        this.user = user;
        this.items = items;
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getCurrency() {
        return currency;
    }

    public BillStatement createStatement(DiscountService discountService){
        BigDecimal totalDiscount = discountService.calculateTotalDiscount(this);
        BigDecimal totalAmount = getTotalAmount();
        BigDecimal totalAfterDiscount = totalAmount.subtract(totalDiscount);
        return BillStatement.builder()
                .currency(currency)
                .totalAmount(totalAmount)
                .discountApplied(totalDiscount)
                .finalAmount(totalAfterDiscount)
                .build();
    }

    private BigDecimal getTotalAmount(){
        return items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private User user;
        private List<Item> items;
        private String currency;

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder items(List<Item> items) {
            this.items = items;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Bill build() {
            return new Bill(user, items, currency);
        }
    }

}
