package com.exercise.dtos;

import java.math.BigDecimal;

public class ItemDTO {

    private String id;
    private String category;
    private BigDecimal price;

    public ItemDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
