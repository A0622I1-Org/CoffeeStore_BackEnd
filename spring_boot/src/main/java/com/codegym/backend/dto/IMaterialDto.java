package com.codegym.backend.dto;

public interface IMaterialDto {
    Long getId();
    String getName();
    Long getTypeId();
    Double getPrice();
    String getUnit();
    Double getQuantity();
}
