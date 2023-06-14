package com.codegym.backend.controller;

import com.codegym.backend.dto.BillDetailDto;
import com.codegym.backend.dto.BillDto;
import com.codegym.backend.model.Bill;
import com.codegym.backend.service.BillDetailService;
import com.codegym.backend.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
@CrossOrigin(origins = "*")
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping("list")
    public ResponseEntity<Page<BillDto>> getBill(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<BillDto> billList = billService.findAll(pageable);
        if(billList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(billList);
    }


    @GetMapping("")
    public ResponseEntity<List<BillDto>> getBillList(){
        List<BillDto> billList = billService.findAll();
        return ResponseEntity.ok(billList);
    }

    @GetMapping("/billDetail/{id}")
    public ResponseEntity<List<BillDetailDto>> getBillDetail(@PathVariable int id){
        List<BillDetailDto> billDetail = billDetailService.findBillById(id);
        return ResponseEntity.ok(billDetail);
    }
}
