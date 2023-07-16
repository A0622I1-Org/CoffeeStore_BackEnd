package com.codegym.backend.service;

import com.codegym.backend.dto.ServiceDto;
import com.codegym.backend.dto.ServiceDto1;
import com.codegym.backend.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<ServiceDto> findBestSeller();
    List<ServiceDto> findNewService();
    Page<Service> findAllService(Pageable pageable);
    Page<ServiceDto1> findService(Pageable pageable,
                                  String serviceName,
                                  String serviceType,
                                  String createdDateF,
                                  String createdDateT,
                                  String priceF,
                                  String priceT,
                                  String quantityF,
                                  String quantityT,
                                  String enableFlag,
                                  String paymentF,
                                  String paymentT);
    Service findById(int id);
    Page<Service> findByServiceTypeId(int type_id,Pageable pageable);
    List<Service> findAll();
    void updateEnableFlag(int flag, int id);
}
