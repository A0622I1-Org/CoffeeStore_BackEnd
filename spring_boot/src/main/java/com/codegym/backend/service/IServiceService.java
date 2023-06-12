package com.codegym.backend.service;

import com.codegym.backend.dto.ServiceDto;
import com.codegym.backend.model.Service;

import java.util.List;

public interface IServiceService {
    List<Service> findBestSeller();

    List<Service> findNewService();
}
