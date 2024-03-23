package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.BillDetailListDTO;
import com.codegym.backend.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
    @Transactional
    @Modifying
    @Query(value = MyQuerySQL.INSERT_BILL_DETAIL,nativeQuery = true)
    void insertBillDetail(int quantity,int billIdd,int serviceId);

    @Transactional
    @Modifying
    @Query(value = MyQuerySQL.SELECT_BILL_DETAIL_LIST_BY_TABLE_ID,nativeQuery = true)
    List<BillDetailListDTO> findByBillId(int tableId);
}
