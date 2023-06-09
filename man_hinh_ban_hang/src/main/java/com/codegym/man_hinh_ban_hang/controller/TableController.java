package com.codegym.man_hinh_ban_hang.controller;

import com.codegym.man_hinh_ban_hang.model.Table;
import com.codegym.man_hinh_ban_hang.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TableController {
    @Autowired
    ITableService tableService;
//    @GetMapping(value = "")
//    ResponseEntity<?> getAllTable(){
//        List<Table> tableList = new ArrayList<>();
//        tableList = tableService.getAllTable();
//
//    }
}
