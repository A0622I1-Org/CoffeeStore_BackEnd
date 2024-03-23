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

    @Query(value = MyQuerySQL.SELECT_USER_ID_FROM_USERNAME, nativeQuery = true)
    int getUserId(String userName);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_PAYMENT_BY_TABLE_ID, nativeQuery = true)
    void updateBillStatusByTableId(String paymentTime, int userId, int tableId);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_PRICE_BILL_DETAIL, nativeQuery = true)
    void updatePriceForBillDetail();
}
