package com.codegym.backend.dto;

public interface BillDetailListDTO {
    public Integer getTableId();
    public String getImgUrl();
    public String getServiceName();
    public Integer getQuantity();
    public Double getPrice();
    public String getTableName();
    public Double getSum();
    public Boolean getPaymentStatus();
}
