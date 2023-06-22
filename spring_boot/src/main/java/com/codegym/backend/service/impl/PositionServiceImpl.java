package com.codegym.backend.service.impl;

import com.codegym.backend.model.Position;
import com.codegym.backend.repository.PositionRepository;
import com.codegym.backend.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
