package com.codegym.man_hinh_ban_hang.service;

import com.codegym.man_hinh_ban_hang.dto.BillDetailListDTO;
import com.codegym.man_hinh_ban_hang.model.CoffeeTable;

import java.util.List;

public interface ICoffeeTableService {
    List<CoffeeTable> getAllTable();
    CoffeeTable findCoffeeTableById(int tableId);

    List<BillDetailListDTO> getBillDetailByTableId(Integer tableId);
}
