package com.codegym.backend.repository;

import com.codegym.backend.dto.ServiceDto;
import com.codegym.backend.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {
    @Query(value = "select * from service where enable_flag = 1",nativeQuery = true)
    Page<Service> findAllService(Pageable pageable);

    @Query(value = "select * from service where enable_flag = 1 and type_id = ?1",nativeQuery = true)
    Page<Service> findByServiceTypeId(int typeId,Pageable pageable);

    @Query(value = "select * from service where id = ?1 and enable_flag = 1",nativeQuery = true)
    Service findById(int id);

    @Query(value = "select * from service where enable_flag = 1",nativeQuery = true)
    List<Service> findAll();
    String sql_best = "SELECT s.id, s.img_url imgUrl, sum(bd.quantity) quantity\n" +
            "FROM service s\n" +
            "JOIN bill_detail bd ON s.id = bd.service_id \n" +
            "GROUP BY s.id\n" +
            "ORDER BY quantity DESC\n" +
            "LIMIT 5;";
    @Query(value = sql_best, nativeQuery = true)
    List<ServiceDto> findBestSeller();

    String sql_new = "SELECT id, name, img_url imgUrl, created_date FROM service ORDER BY created_date DESC LIMIT 5";
    @Query(value = sql_new, nativeQuery = true)
    List<ServiceDto> findNewService();
}
