package com.codegym.backend.dto;

import javax.persistence.criteria.CriteriaBuilder;

public interface BillDTO {
    public Integer getId();
    public String getCreatedTime();
    public Boolean getPaymentStatus();
    public String getPaymentTime();
    public Integer getTableId();
    public Integer getUserId();
}
