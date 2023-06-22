package com.codegym.backend.repository;

import com.codegym.backend.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<AppRole, Integer> {



    @Modifying
    @Query(value = "insert into account_role (account_id,role_id) values (?1,?2)", nativeQuery = true)
    void setDefaultRole(Integer accountId, Integer roleId);
}
