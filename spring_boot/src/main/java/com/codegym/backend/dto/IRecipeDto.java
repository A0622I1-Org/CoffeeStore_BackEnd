package com.codegym.backend.dto;

public interface IRecipeDto {
    Long getId();
    String getName();
    Long getServiceId();
    String getMaterialId();
    Double getQuantity();
    String getUnit();
    Double getPrice();
}
