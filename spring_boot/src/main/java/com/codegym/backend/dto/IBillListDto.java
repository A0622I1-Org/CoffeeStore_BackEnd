package com.codegym.backend.dto;

public interface IBillListDto {
    Integer getId();
    String getCreatedTime();
    String getTableNumber();
    String getName();
    Double getTotalPayment();
}
