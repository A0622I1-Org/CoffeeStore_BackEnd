package com.codegym.backend.repository;

import com.codegym.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT * FROM account where user_name = ?1", nativeQuery = true)
    Optional<Account> findAccountByUserName(String username);

    @Query(value = "SELECT id FROM account where user_name = ?1", nativeQuery = true)
    Integer findIdByUserName(String username);

    @Query(value = "SELECT user_name FROM account where user_name = ?1", nativeQuery = true)
    String existsByUserName(String username);

    @Query(value = "SELECT email FROM account where email = ?1", nativeQuery = true)
    String existsByEmail(String email);

    @Query(value = "SELECT change_password_date FROM account where user_name = ?1", nativeQuery = true)
    String findChangPassworDateByUserName(String username);

    @Modifying
    @Query(value = "update account set verification_code= ?1 where user_name = ?2", nativeQuery = true)
    void addVerificationCode(String code, String username);

    @Query(value = "select * from account where verification_code = ?1", nativeQuery = true)
    Account findAccountByVerificationCode(String code);

    @Modifying
    @Query(value = "update account set password = ?1,verification_code= null where verification_code= ?2", nativeQuery = true)
    void saveNewPassword(String encryptPassword, String code);
}
