package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.BillChargingListDTO;
import com.codegym.backend.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IBillChargingRepository extends JpaRepository<Bill, Integer> {
    @Modifying
    @Query(value = MyQuerySQL.SELECT_CHARGING_BILL, nativeQuery = true)
    List<BillChargingListDTO> getAllBillCharging(Integer tableId);

    @Query(value = "SELECT u.id FROM user u " +
            "JOIN account a ON u.account_id = a.id " +
            "WHERE a.user_name = ?1", nativeQuery = true)
    int getUserId(String userName);

    @Modifying
    @Query(value = "UPDATE bill SET payment_status = 1, payment_time = ?1, user_id = ?2\n" +
            "WHERE table_id = ?3", nativeQuery = true)
    void updateBillStatusByTableId(String paymentTime, int userId, int tableId);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_PRICE_BILL_DETAIL, nativeQuery = true)
    void updatePriceForBillDetail();
}
