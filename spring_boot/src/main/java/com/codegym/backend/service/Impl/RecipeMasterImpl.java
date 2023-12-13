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
    public void insertRecipe(Long serviceId, Long materialId, Double quantity, Double price) {
        iRecipeRepository.insertRecipe(serviceId, materialId, quantity, price);
    }

    @Override
    public void updateRecipe(Double quantity, Double price,Long id) {
        iRecipeRepository.updateRecipe(quantity, price, id);
    }

    @Override
    public void deleteRecipe(Long id) {
        iRecipeRepository.deleteRecipe(id);
    }

    @Override
    public Long findLastServiceId() {
        return iRecipeRepository.findLastServiceId();
    }
}