package com.codegym.backend.repository;

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
    Page<Service> findByServiceTypeId(int type_id,Pageable pageable);

    @Query(value = "select * from service where id = ?1 and enable_flag = 1",nativeQuery = true)
    Service findById(int id);

    @Query(value = "select * from service where enable_flag = 1",nativeQuery = true)
    List<Service> findAll();
}
