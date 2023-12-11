package com.codegym.backend.service;

import com.codegym.backend.dto.IMaterialDto;
import com.codegym.backend.repository.IMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMaterialService {
    List<IMaterialDto> findAllMaterial();

}
