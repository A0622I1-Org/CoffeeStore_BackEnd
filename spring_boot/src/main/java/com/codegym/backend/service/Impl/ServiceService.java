package com.codegym.backend.service.impl;

import com.codegym.backend.dto.*;
import com.codegym.backend.model.Service;
import com.codegym.backend.repository.IServiceRepository;
import com.codegym.backend.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
                                         String paymentTimeF,
                                         String paymentTimeT,
                                         String quantityF,
                                         String quantityT,
                                         String enableFlag,
                                         String paymentF,
                                         String paymentT) {
        return iServiceRepository.getServiceList(
                pageable,
                serviceName,
                serviceType,
                createdDateF,
                createdDateT,
                priceF,
                priceT,
                paymentTimeF,
                paymentTimeT,
                quantityF,
                quantityT,
                enableFlag,
                paymentF,
                paymentT);
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
                Integer.parseInt(serviceDto.getEnableFlag()), serviceDto.getImgUrl(), serviceDto.getDescribe());
    }

    @Override
    public List<IRecipeDto> findRecipeByServiceId(int service_id) {
        return iServiceRepository.getRecipeByServiceId(service_id);
    }
}
