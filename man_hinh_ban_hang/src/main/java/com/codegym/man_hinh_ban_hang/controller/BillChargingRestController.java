package com.codegym.man_hinh_ban_hang.controller;

import com.codegym.man_hinh_ban_hang.dto.BillChargingListDTO;
import com.codegym.man_hinh_ban_hang.dto.BillDetailListDTO;
import com.codegym.man_hinh_ban_hang.model.Bill;
import com.codegym.man_hinh_ban_hang.model.CoffeeTable;
import com.codegym.man_hinh_ban_hang.service.IBillChargingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillChargingRestController {
    @Autowired
    IBillChargingService billChargingService;
    @GetMapping("/sales/bill-charging/{tableId}")
    public ResponseEntity<List<BillChargingListDTO>> getBillChargingByTableId(@PathVariable Integer tableId) {
        List<BillChargingListDTO> billChargingList = billChargingService.getAllBillCharging(tableId);
        if (billChargingList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billChargingList, HttpStatus.OK);
    }
//    @PutMapping("/sales/bill")
//    public ResponseEntity<List<Bill>> updateBillStatus() {
//
//    }
}
