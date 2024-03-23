package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.BillDetailDto;
import com.codegym.backend.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Integer> {
    @Query(value = MyQuerySQL.SELECT_BILL_DETAIL_BILL_DETAIL_DTO, nativeQuery = true)
    List<BillDetailDto> getBillDetail(int id);
}
