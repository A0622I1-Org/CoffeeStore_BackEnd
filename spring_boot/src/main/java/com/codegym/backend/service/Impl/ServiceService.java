package com.codegym.backend.service.impl;

import com.codegym.backend.dto.CServiceDto;
import com.codegym.backend.dto.ServiceDto;
import com.codegym.backend.dto.IServiceDto;
import com.codegym.backend.model.Account;
import com.codegym.backend.model.Service;
import com.codegym.backend.repository.IServiceRepository;
import com.codegym.backend.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository iServiceRepository;

    @Override
    public List<ServiceDto> findBestSeller() {
        return iServiceRepository.findBestSeller();
    }

    @Override
    public List<ServiceDto> findNewService() {
        return iServiceRepository.findNewService();
    }

    @Override
    public Page<Service> findAllService(Pageable pageable) {
        return iServiceRepository.findAllService(pageable);
    }

    @Override
    public Page<IServiceDto> findService(Pageable pageable,
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
                                         String paymentT,
                                         String paymentTimeF,
                                         String paymentTimeT) {
        return iServiceRepository.getServiceList(
                pageable,
                serviceName,
                serviceType,
                createdDateF,
                createdDateT,
                priceF,
                priceT,
                quantityF,
                quantityT,
                enableFlag,
                paymentF,
                paymentT,
                paymentTimeF,
                paymentTimeT);
    }

    @Override
    public List<CServiceDto> findAllForRegister() {
        return iServiceRepository.getServiceListForRegister();
    }

    @Override
    public Service findById(int id) {
        return iServiceRepository.findById(id);
    }

    @Override
    public Page<Service> findByServiceTypeId(int type_id, Pageable pageable) {
        return iServiceRepository.findByServiceTypeId(type_id,pageable);
    }

    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }


    @Override
    public void updateEnableFlag(int flag, int id) {
        iServiceRepository.updateServiceEnableFlag(flag, id);
    }

    @Override
    public void createService(CServiceDto serviceDto) {
        iServiceRepository.createNewService(serviceDto.getName(), serviceDto.getPrice(), serviceDto.getTypeId(),
                Integer.parseInt(serviceDto.getEnableFlag()), serviceDto.getImgUrl());
    }
}
