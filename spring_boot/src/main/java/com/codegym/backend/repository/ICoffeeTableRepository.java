package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.BillDetailListDTO;
import com.codegym.backend.model.CoffeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICoffeeTableRepository extends JpaRepository<CoffeeTable, Integer> {
    /**
     * @param tableId
     * @param paymentTime
     * @param userId
     * @author CuongHM
     * @Date 11/06/2023
     * @Result Update bill payment status, payment time and user id.
     */
    @Modifying
    @Query(value = "UPDATE bill SET payment_status = 1, payment_time = ?2, user_id = ?3 WHERE table_id = ?1;", nativeQuery = true)
    void updateBillStatusById(int tableId, String paymentTime, int userId);

    @Modifying
    @Query(value = "SELECT * FROM `table` WHERE status = 'Tốt' OR 'tốt';", nativeQuery = true)
    List<CoffeeTable> getAllTable();

    @Modifying
    @Query(value = MyQuerySQL.SELECT_BILL_DETAIL, nativeQuery = true)
    List<BillDetailListDTO> getBillDetailByTableId(Integer tableId);

    @Query(value = "SELECT * from `table` WHERE id = ?", nativeQuery = true)
    CoffeeTable findCoffeeTableById(int tableId);

    @Modifying
    @Query(value = "UPDATE `table` SET enable_flag = 0 WHERE id = ?", nativeQuery = true)
    void updateTableStatus(int tableId);
}
