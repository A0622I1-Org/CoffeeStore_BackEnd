package com.codegym.man_hinh_ban_hang.controller;

import com.codegym.man_hinh_ban_hang.model.CoffeeTable;
import com.codegym.man_hinh_ban_hang.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CoffeeTableController {
    @Autowired
    ICoffeeTableService tableService;
    @GetMapping("")
    public String showTableList(Model model){
        List<CoffeeTable> tableList = tableService.getAllTable();
        model.addAttribute("tableList", tableList);
        return "man_hinh_ban_hang";
    }
}
