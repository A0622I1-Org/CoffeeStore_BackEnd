package com.codegym.backend.service;

import com.codegym.backend.dto.CServiceDto;
import com.codegym.backend.dto.ServiceDto;
import com.codegym.backend.dto.IServiceDto;
import com.codegym.backend.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<ServiceDto> findBestSeller();
    List<ServiceDto> findNewService();
    Page<Service> findAllService(Pageable pageable);
    Page<IServiceDto> findService(Pageable pageable,
                                  String serviceName,
                                  String serviceType,
                                  String createdDateF,
                                  String createdDateT,
                                  String priceF,
                                  String priceT,
                                  String paymentTimeF,
                                  String paymentTimeT,
                                  String quantityF,
                                  String quantityT,
                                  String enableFlag,
                                  String paymentF,
                                  String paymentT);
    Service findById(int id);
    Page<Service> findByServiceTypeId(int type_id,Pageable pageable);
    List<Service> findAll();
    List<CServiceDto> findAllForRegister();
    void updateEnableFlag(int flag, int id);
    void createService(CServiceDto serviceDto);
}
