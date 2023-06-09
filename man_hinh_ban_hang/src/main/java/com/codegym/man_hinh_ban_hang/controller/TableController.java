package com.codegym.man_hinh_ban_hang.controller;

import com.codegym.man_hinh_ban_hang.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TableController {
    @Autowired
    ITableService tableService;
//    @GetMapping(value = "")
//    ResponseEntity<?> getAllTable(){
//        List<CoffeeTable> tableList = new ArrayList<>();
//        tableList = tableService.getAllTable();
//
//    }
}
