package com.codegym.backend.service.impl;

import com.codegym.backend.dto.BillDetailDto;
import com.codegym.backend.dto.BillDto;
import com.codegym.backend.model.Bill;
import com.codegym.backend.repository.BillRepository;
import com.codegym.backend.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;


    @Override
    public List<BillDto> findAll( ) {
        return billRepository.getAllBill();
    }

    @Override
    public Page<BillDto> findAll(Pageable pageable) {
        return billRepository.findAllList(pageable);
    }
}
