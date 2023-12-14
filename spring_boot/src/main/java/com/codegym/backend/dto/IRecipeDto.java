package com.codegym.backend.dto;

public interface IRecipeDto {
    Long getId();
    String getName();
    Long getServiceId();
    Long getMaterialId();
    Double getQuantity();
    String getUnit();
    Double getPrice();
}
