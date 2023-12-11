package com.codegym.backend.dto;

public class RecipeDto {
    Long materialId;
    Double quantity;
    Double price;

    public RecipeDto(Long materialId, Double quantity, Double price) {
        this.materialId = materialId;
        this.quantity = quantity;
        this.price = price;
    }

    public RecipeDto() {
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
