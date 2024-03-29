package com.codegym.backend.repository;

import com.codegym.backend.model.CoffeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository

public interface ITableRepository extends JpaRepository<CoffeeTable,Integer> {
    @Query(value = "select * from `table` where status like 'tốt'",nativeQuery = true)
    List<CoffeeTable> findAllTable();
    @Transactional
    @Modifying
    @Query(value = "UPDATE `table` SET enable_flag = 1 WHERE id = ?", nativeQuery = true)
    void updateTableStatus(int tableId);
}
