package com.codegym.backend.repository;

import com.codegym.backend.dto.ServiceDto;
import com.codegym.backend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
    String sql_best = "SELECT s.name, s.imgurl, COUNT(bd.service_id) AS service_count  " +
            "FROM service AS s   " +
            "JOIN bill_detail AS bd ON s.id = bd.service_id   " +
            "GROUP BY s.id, s.name   " +
            "ORDER BY service_count DESC   " +
            "LIMIT 5;";
    @Query(value = sql_best, nativeQuery = true)
    List<ServiceDto> findBestSeller();



    @Query(value = "SELECT id, name, imgurl, created_date FROM service ORDER BY created_date DESC LIMIT 5;", nativeQuery = true)
    List<ServiceDto> findNewService();
}
