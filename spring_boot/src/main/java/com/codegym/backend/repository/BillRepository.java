package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.BillListDto;
import com.codegym.backend.dto.IBillListDto;
import com.codegym.backend.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = MyQuerySQL.SELECT_ALL_BILL_BILL_LIST_DTO, countQuery = MyQuerySQL.SELECT_ALL_BILL_BILL_LIST_DTO, nativeQuery = true)
    Page<BillListDto> findAllList(Pageable pageable);

    @Query(value = MyQuerySQL.SELECT_BILL_LIST_BY_USER_BILL_LIST_DTO, countQuery = MyQuerySQL.SELECT_BILL_LIST_BY_USER_BILL_LIST_DTO, nativeQuery = true)
    Page<BillListDto> findBillByUser(Pageable pageable,String name);

    @Query(value = MyQuerySQL.SELECT_BILL, countQuery = MyQuerySQL.SELECT_BILL,  nativeQuery = true)
    Page<IBillListDto> getBillList(Pageable pageable,
                                   String billNo,
                                   String createdDateF,
                                   String createdDateT,
                                   String createdBy,
                                   String tableNo,
                                   String paymentF,
                                   String paymentT);
}
