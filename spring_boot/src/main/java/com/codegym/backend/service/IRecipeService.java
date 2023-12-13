package com.codegym.backend.service;


public interface IRecipeService {
    void insertRecipe(Long serviceId, Long materialId, Double quantity, Double price);
    void updateRecipe(Double quantity, Double price,Long id);
    void deleteRecipe(Long id);
    Long findLastServiceId();
}
