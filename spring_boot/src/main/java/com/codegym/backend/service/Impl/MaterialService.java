package com.codegym.backend.service.impl;

import com.codegym.backend.dto.IMaterialDto;
import com.codegym.backend.repository.IMaterialRepository;
import com.codegym.backend.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService implements IMaterialService {
    @Autowired
    IMaterialRepository iMaterialRepository;

    @Override
    public List<IMaterialDto> findAllMaterial() {
        return iMaterialRepository.getAllMaterial();
    }

}
