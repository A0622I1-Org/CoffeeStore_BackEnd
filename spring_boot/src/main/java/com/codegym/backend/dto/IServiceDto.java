package com.codegym.backend.dto;

public interface IServiceDto {
    Integer getId();
    String getImgUrl();
    String getServiceName();
    Double getPrice();
    String getServiceType();
    String getCreatedDate();
    Double getSalePrice();
    Double getQuantity();
    Double getPayment();
    String getStatusFlag();
}