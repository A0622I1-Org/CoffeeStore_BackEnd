package com.codegym.backend.service.impl;

import com.codegym.backend.repository.IRecipeRepository;
import com.codegym.backend.service.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeMasterImpl implements IRecipeService {
    @Autowired
    IRecipeRepository iRecipeRepository;

    @Override
    public void insertRecipe(Long materialId, Double quantity, Double price) {
        int serviceId = iRecipeRepository.findLastServiceId();
        iRecipeRepository.insertRecipe(serviceId, materialId, quantity, price);
    }
}
