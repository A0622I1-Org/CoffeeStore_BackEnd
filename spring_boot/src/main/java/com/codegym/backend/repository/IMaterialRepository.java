package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.IMaterialDto;
import com.codegym.backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IMaterialRepository  extends JpaRepository<Material, Integer> {

    @Query(value = MyQuerySQL.SELECT_MATERIAL, nativeQuery = true)
    List<IMaterialDto> getAllMaterial();
}
