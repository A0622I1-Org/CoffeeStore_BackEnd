package com.codegym.backend.controller;

import com.codegym.backend.dto.BillDetailListDTO;
import com.codegym.backend.model.CoffeeTable;
import com.codegym.backend.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class CoffeeTableRestController {
    @Autowired
    ICoffeeTableService tableService;

    /**
     * <h3>Description: Hiển thị danh sách bàn không bị hư hại.</h3>
     *
     * @return List of table
     * @author CuongHM
     */
    @GetMapping("/sales")
    public ResponseEntity<Iterable<CoffeeTable>> getAllTable() {
        List<CoffeeTable> tableList = tableService.getAllTable();
        if (tableList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableList, HttpStatus.OK);
    }

    /**
     * <h3>Description: Tính tiền bàn đã chọn, và đưa bàn đó về trạng thái không có khách.</h3>
     *
     * @param tableId
     * @param userId
     * @return Hóa đơn của bàn vừa được tính tiền
     * @author CuongHM
     */
    @GetMapping("/sales/bill/{tableId}")
    public ResponseEntity<List<BillDetailListDTO>> getBillDetailByTableId(@PathVariable Integer tableId) {
        List<BillDetailListDTO> billDetailListDTOList = tableService.getBillDetailByTableId(tableId);
        if (billDetailListDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billDetailListDTOList, HttpStatus.OK);
    }
}
