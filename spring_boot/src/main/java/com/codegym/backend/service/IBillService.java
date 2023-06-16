package com.codegym.backend.service;

import com.codegym.backend.dto.BillDTO;
import com.codegym.backend.model.Bill;

public interface IBillService {
    BillDTO findByIdBill(int table_id);
    void insertBill(String created_time,int payment_status,String payment_time,int table_id,int user_id);
}
