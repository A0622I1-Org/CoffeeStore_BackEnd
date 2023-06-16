package com.codegym.backend.dto;

import java.util.Date;

public interface BillDto {
    Integer getId();
    String getTableNumber();
    String getName();
    Integer getTotalPrice();
    String getCreatedTime();
}
