package com.exercise.exchangepay.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Data Transfer Object for an item in the bill")
public class ItemDTO {

    @Schema(description = "Unique identifier of the item", example = "ITEM123")
    private String id;
    @Schema(description = "Category of the item (e.g., GROCERIES, ELECTRONICS, CLOTHING)", example = "ELECTRONICS")
    private String category;
    @Schema(description = "Price of the item", example = "49.99")
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
