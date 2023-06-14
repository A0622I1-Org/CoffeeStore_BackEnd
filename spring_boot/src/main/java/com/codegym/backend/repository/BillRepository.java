package com.codegym.backend.repository;

import com.codegym.backend.dto.BillDetailDto;
import com.codegym.backend.dto.BillDto;
import com.codegym.backend.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "select b.id, t.id as tableNumber, u.name, sum(bd.quantity*s.price) as totalPrice from  bill b " +
            "join `table` t on b.table_id = t.id " +
            "join user u on b.user_id =u.id " +
            "join bill_detail bd on bd.bill_id = b.id " +
            "join service s on bd.service_id = s.id " +
            "group by b.id " +
            "order by b.id", nativeQuery = true)
    Page<BillDto> findAllList(Pageable pageable);

    @Query(value = "select b.id, t.id as tableNumber, u.name, sum(bd.quantity*s.price) as totalPrice from  bill b " +
            "join `table` t on b.table_id = t.id " +
            "join user u on b.user_id =u.id " +
            "join bill_detail bd on bd.bill_id = b.id " +
            "join service s on bd.service_id = s.id " +
            "group by b.id " +
            "order by b.id", nativeQuery = true)
    List<BillDto> getAllBill();
}
