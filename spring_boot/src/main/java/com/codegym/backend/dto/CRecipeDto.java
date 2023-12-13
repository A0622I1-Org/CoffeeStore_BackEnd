package com.codegym.backend.dto;

public class CRecipeDto {
    Long id;
    String name;
    Long serviceId;
    Long materialId;
    Double quantity;
    Double price;
    String unit;

    public CRecipeDto() {
    }

    public CRecipeDto(Long id, String name, Long serviceId, Long materialId, Double quantity, Double price, String unit) {
        this.id = id;
        this.name = name;
        this.serviceId = serviceId;
        this.materialId = materialId;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
