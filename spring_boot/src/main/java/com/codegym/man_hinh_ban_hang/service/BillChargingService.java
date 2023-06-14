package com.codegym.man_hinh_ban_hang.service;

import com.codegym.man_hinh_ban_hang.dto.BillChargingListDTO;
import com.codegym.man_hinh_ban_hang.repository.IBillChargingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class BillChargingService implements IBillChargingService{
    @Autowired
    IBillChargingRepository billChargingRepository;

    @Override
    public List<BillChargingListDTO> getAllBillCharging(Integer tableId) {
        return billChargingRepository.getAllBillCharging(tableId);
    }

    @Override
    public void updateBillStatusByTableId(String paymentTime, int userId, int tableId) {
        billChargingRepository.updateBillStatusByTableId(paymentTime, userId, tableId);
    }
}
