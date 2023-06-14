package com.codegym.man_hinh_ban_hang.controller;

import com.codegym.man_hinh_ban_hang.dto.BillDetailListDTO;
import com.codegym.man_hinh_ban_hang.model.CoffeeTable;
import com.codegym.man_hinh_ban_hang.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CoffeeTableRestController {
    @Autowired
    ICoffeeTableService tableService;

    @GetMapping("/sales")
    public ResponseEntity<Iterable<CoffeeTable>> getAllTable() {
        List<CoffeeTable> tableList = tableService.getAllTable();
        if (tableList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableList, HttpStatus.OK);
    }
    @GetMapping("/sales/bill/{tableId}")
    public ResponseEntity<List<BillDetailListDTO>> getBillDetailByTableId(@PathVariable Integer tableId) {
        List<BillDetailListDTO> billDetailListDTOList = tableService.getBillDetailByTableId(tableId);
        if (billDetailListDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billDetailListDTOList, HttpStatus.OK);
    }
}
