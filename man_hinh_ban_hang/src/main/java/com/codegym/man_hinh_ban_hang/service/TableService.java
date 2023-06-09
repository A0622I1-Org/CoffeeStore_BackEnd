package com.codegym.man_hinh_ban_hang.service;

import com.codegym.man_hinh_ban_hang.model.Table;
import com.codegym.man_hinh_ban_hang.repository.ITableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService implements ITableService{
    @Autowired
    ITableRepository tableRepository;
    @Override
    public List<Table> getAllTable() {
        return tableRepository.getAllTable();
    }
}
