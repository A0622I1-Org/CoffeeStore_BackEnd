package com.codegym.backend.dto;

public interface BillDTO {
    public Integer getId();
    public String getCreatedTime();
    public Boolean getPaymentStatus();
    public String getPaymentTime();
    public Integer getTableId();
    public Integer getUserId();
}
