package com.codegym.man_hinh_ban_hang.dto;

public interface BillDetailListDTO {
//    public Integer getBillId();
    public Integer getTableId();
    public String getImgUrl();
    public String getServiceName();
    public Integer getQuantity();
    public Double getPrice();
    public Double getSum();
    public Boolean getPaymentStatus();
}
