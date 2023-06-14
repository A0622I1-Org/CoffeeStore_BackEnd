package com.codegym.man_hinh_ban_hang.repository;

import com.codegym.man_hinh_ban_hang.dto.BillChargingListDTO;
import com.codegym.man_hinh_ban_hang.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillChargingRepository extends JpaRepository<Bill, Integer> {
    @Modifying
    @Query(value = "SELECT b.id AS billId, b.user_id AS userId, b.table_id AS tableId, " +
            " b.payment_status AS paymentStatus, b.payment_time AS paymentTime, sum(bd.quantity * s.price) AS sum from bill b\n" +
            "JOIN bill_detail bd ON bd.bill_id = b.id\n" +
            "JOIN service s ON s.id = bd.service_id\n" +
            "WHERE b.payment_status = 0 AND b.table_id = ?1 \n" +
            "GROUP BY b.table_id;", nativeQuery = true)
    List<BillChargingListDTO> getAllBillCharging(Integer tableId);

    @Modifying
    @Query(value = "UPDATE bill SET payment_status = 1, payment_time = ?, user_id = ?\n" +
            "WHERE table_id = ?", nativeQuery = true)
    void updateBillStatusByTableId(String paymentTime, int userId, int tableId);

}
