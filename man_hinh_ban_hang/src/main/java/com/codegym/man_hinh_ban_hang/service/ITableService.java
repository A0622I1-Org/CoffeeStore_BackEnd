package com.codegym.man_hinh_ban_hang.service;

import com.codegym.man_hinh_ban_hang.model.Table;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITableService {
    List<Table> getAllTable();
}
