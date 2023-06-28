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
@RequestMapping("/api/private")
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
     * <h3>Description: Hiển thị hóa đơn các món đã chọn của bàn đó.</h3>
     *
     * @param tableId
     * @return Danh sách chi tiết món ăn, số lượng và tổng giá từng món.
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
