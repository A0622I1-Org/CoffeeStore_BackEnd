package com.codegym.man_hinh_ban_hang.service;

import com.codegym.man_hinh_ban_hang.model.CoffeeTable;
import com.codegym.man_hinh_ban_hang.repository.ICoffeeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeTableService implements ICoffeeTableService {
    @Autowired
    ICoffeeTableRepository tableRepository;
    @Override
    public List<CoffeeTable> getAllTable() {
        return tableRepository.getAllTable();
    }
}
