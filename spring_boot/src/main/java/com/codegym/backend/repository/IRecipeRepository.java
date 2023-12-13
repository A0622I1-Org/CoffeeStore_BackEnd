package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {

    @Modifying
    @Query(value = MyQuerySQL.INSERT_RECIPE, nativeQuery = true)
    void insertRecipe(Long serviceId, Long materialId, Double quantity, Double price);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_RECIPE, nativeQuery = true)
    void updateRecipe(Double quantity, Double price,Long id);

    @Modifying
    @Query(value = MyQuerySQL.DELETE_RECIPE, nativeQuery = true)
    void deleteRecipe(Long id);

    @Query(value = MyQuerySQL.SELECT_LAST_SERVICE_ID, nativeQuery = true)
    Long findLastServiceId();
}
