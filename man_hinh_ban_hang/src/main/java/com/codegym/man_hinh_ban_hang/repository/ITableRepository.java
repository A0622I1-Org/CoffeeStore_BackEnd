package com.codegym.man_hinh_ban_hang.repository;

import com.codegym.man_hinh_ban_hang.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITableRepository extends JpaRepository<Table, Integer> {
    @Modifying
    @Query(value = "UPDATE bill SET payment_status = 1 WHERE id = ?1", nativeQuery = true)
    void updateBillStatusById(int billId);
}
