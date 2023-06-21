package com.codegym.backend.repository;

import com.codegym.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Modifying
    @Query(value = "update account set password =?1 where user_name=?2 ", nativeQuery = true)
    void changePassword(String password, String userName);
    
    @Query(value = "SELECT * FROM account where user_name = ?1", nativeQuery = true)
    Optional<Account> findAccountByUserName(String username);
}
