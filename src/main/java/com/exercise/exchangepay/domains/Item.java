package com.exercise.exchangepay.domains;

import com.exercise.exchangepay.domains.enums.ItemCategory;

import java.math.BigDecimal;


public class Item {

    private final String id;
    private final ItemCategory category;
    private final BigDecimal price;

    public Item() {
        this.id = null;
        this.category = null;
        this.price = null;
    }

    public Item(String id, ItemCategory category, BigDecimal price) {
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isGrocery(){
        return category.equals(ItemCategory.GROCERY);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private ItemCategory category;
        private BigDecimal price;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder category(ItemCategory category) {
            this.category = category;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Item build() {
            return new Item(id, category, price);
        }
    }

}
