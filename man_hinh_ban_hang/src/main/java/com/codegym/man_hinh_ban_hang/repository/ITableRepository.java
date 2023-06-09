package com.codegym.man_hinh_ban_hang.repository;

import com.codegym.man_hinh_ban_hang.model.CoffeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITableRepository extends JpaRepository<CoffeeTable, Integer> {
    /**
     *
     * @param tableId
     * @param paymentTime
     * @param userId
     */
    @Modifying
    @Query(value = "UPDATE bill SET payment_status = 1, payment_time = ?2, user_id = ?3 WHERE table_id = ?1;", nativeQuery = true)
    void updateBillStatusById(int tableId, String paymentTime, int userId);

    @Modifying
    @Query(value = "SELECT * FROM `table` WHERE status = 'Tốt' OR 'tốt';", nativeQuery = true)
    List<CoffeeTable> getAllTable();
}
