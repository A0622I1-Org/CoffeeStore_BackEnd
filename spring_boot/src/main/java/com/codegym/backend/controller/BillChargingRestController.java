package com.codegym.backend.controller;

import com.codegym.backend.dto.BillChargingListDTO;
import com.codegym.backend.model.Bill;
import com.codegym.backend.model.CoffeeTable;
import com.codegym.backend.service.IBillChargingService;
import com.codegym.backend.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class BillChargingRestController {
    @Autowired
    IBillChargingService billChargingService;
    @Autowired
    ICoffeeTableService tableService;

    /**
     * <h3>Description: Hiển thị thành tiền, trạng thái và số bàn của hóa đơn.</h3>
     * @author CuongHM
     * @param tableId
     * @return Thành tiền, số bàn của hóa đơn
     */
    @GetMapping("/sales/bill-charging/{tableId}")
    public ResponseEntity<List<BillChargingListDTO>> getBillChargingByTableId(@PathVariable Integer tableId) {
        List<BillChargingListDTO> billChargingList = billChargingService.getAllBillCharging(tableId);
        if (billChargingList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billChargingList, HttpStatus.OK);
    }

    /**
     *
     * <h3>Description: Tính tiền bàn đã chọn, và đưa bàn đó về trạng thái không có khách.</h3>
     * @author CuongHM
     * @param tableId
     * @param userId
     * @return Hóa đơn của bàn vừa được tính tiền
     */
    @GetMapping("/sales/bill-charge/{tableId}/{userId}")
    public ResponseEntity<List<BillChargingListDTO>> updateBillStatus(@PathVariable int tableId, @PathVariable int userId) {
        List<BillChargingListDTO> billChargingList = billChargingService.getAllBillCharging(tableId);
        if (billChargingList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        billChargingService.updateBillStatusByTableId(dtf.format(date), userId, tableId);
        tableService.updateTableStatus(tableId);
        return new ResponseEntity<>(billChargingList, HttpStatus.OK);
    }
}
