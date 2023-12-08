package com.codegym.backend.dto;

public interface IRecipeDto {
    Long getId();
    String getName();
    Double getQuantity();
    String getUnit();
    Double getPrice();
}
