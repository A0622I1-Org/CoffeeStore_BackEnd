package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.BillDto;
import com.codegym.backend.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IBillRepository extends JpaRepository<Bill,Integer> {

    @Query(value = MyQuerySQL.SELECT_BILL_BY_TABLE_ID,nativeQuery = true)
    BillDto findByIdBill(int table_id);

    @Modifying
    @Query(value = MyQuerySQL.INSERT_BILL,nativeQuery = true)
    void insertBill(String createdTime,int paymentStatus,String paymentTime,int tableId,int userId);
}
