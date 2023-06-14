package com.codegym.backend.repository;

import com.codegym.backend.model.CoffeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITableRepository extends JpaRepository<CoffeeTable,Integer> {
    @Query(value = "select * from `table` where enable_flag = 1",nativeQuery = true)
    List<CoffeeTable> findAllTable();
}
