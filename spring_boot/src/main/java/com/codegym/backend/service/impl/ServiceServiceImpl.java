package com.codegym.backend.service.impl;

import com.codegym.backend.model.Service;
import com.codegym.backend.repository.IServiceRepository;
import com.codegym.backend.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    IServiceRepository repository;
    @Override
    public List<Service> findBestSeller() {
        return repository.findBestSeller();
    }

    @Override
    public List<Service> findNewService() {
        return repository.findNewService();
    }
}
