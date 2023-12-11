package com.codegym.backend.service;

import com.codegym.backend.model.Material;

public interface IRecipeService {
    void insertRecipe(Long materialId, Double quantity, Double price);
}
