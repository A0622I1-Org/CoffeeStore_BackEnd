package com.codegym.backend.repository;

import com.codegym.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> findAllUser();

    @Query(value = "SELECT * FROM user where account_id = ?1 and enable_flag = ?2", nativeQuery = true)
    User findByAccountId(int accountId, Boolean enableFlag);

    @Query(value = "SELECT name FROM user where account_id = ?1 and enable_flag = ?2", nativeQuery = true)
    String findNameByAccountId(int accountId, Boolean enableFlag);
}
