package com.codegym.man_hinh_ban_hang.dto;

public interface BillDetailList {
    public Integer billId();
    public Integer tableId();
    public String imgUrl();
    public String serviecName();
    public Integer quantity();
    public Double price();
    public Double sum();
    public Boolean paymentStatus();
}
