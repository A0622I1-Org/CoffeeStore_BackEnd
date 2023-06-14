package com.codegym.man_hinh_ban_hang.service;

import com.codegym.man_hinh_ban_hang.dto.BillChargingListDTO;

import java.util.List;

public interface IBillChargingService {
    List<BillChargingListDTO> getAllBillCharging(Integer tableId);
    void updateBillStatusById(String paymentTime, int userId, int billId);
}
