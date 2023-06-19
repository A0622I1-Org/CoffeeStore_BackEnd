package com.codegym.backend.repository;

import com.codegym.backend.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
    @Query(value = "select * from service_type",nativeQuery = true)
    List<ServiceType> findAllServiceType();
}
