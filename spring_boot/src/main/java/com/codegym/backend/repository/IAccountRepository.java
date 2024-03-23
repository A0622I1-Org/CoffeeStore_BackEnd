package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.model.Account;
import com.codegym.backend.dto.AccountListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


import java.util.List;



@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_USER_PASS, nativeQuery = true)
    void changePassword(String password, String date,String userName);

    @Query(value = MyQuerySQL.SELECT_PASSWORD_BY_USERNAME, nativeQuery = true)
    String getCurrentPassword(String userName);

    @Query(value = MyQuerySQL.SELECT_ACCOUNT_BY_USERNAME, nativeQuery = true)
    Optional<Account> findAccountByUserName(String username);

    @Query(value = MyQuerySQL.SELECT_ID_BY_USERNAME, nativeQuery = true)
    Integer findIdByUserName(String username);

    @Query(value = MyQuerySQL.SELECT_USERNAME_BY_USERNAME, nativeQuery = true)
    String existsByUserName(String username);

    @Query(value = MyQuerySQL.SELECT_EMAIL_BY_EMAIL, nativeQuery = true)
    String existsByEmail(String email);

    @Query(value = MyQuerySQL.SELECT_CHANGE_PASSWORD_DATE_BY_USERNAME, nativeQuery = true)
    String findChangPassworDateByUserName(String username);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_VERIFICATION_CODE_BY_USERNAME, nativeQuery = true)
    void addVerificationCode(String code, String username);

    @Query(value = MyQuerySQL.SELECT_ACCOUNT_BY_VERIFICATION_CODE, nativeQuery = true)
    Account findAccountByVerificationCode(String code);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_PASSWORD_BY_VERIFICATION_CODE, nativeQuery = true)
    void saveNewPassword(String encryptPassword, String code);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_CHANGE_PASSWORD_DATE_BY_VERIFICATION_CODE, nativeQuery = true)
    void updateChangePassworkDate(String dateNow, String code);

    @Query(value = MyQuerySQL.SELECT_ID_BY_USERNAME, nativeQuery = true)
    Integer findIdUserByUserName(String userName);

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_EMAIL_BY_USERNAME, nativeQuery = true)
    void updateEmailAccount(String email, String username);

    @Query(value = MyQuerySQL.SELECT_ACCOUNT_LIST, nativeQuery = true)
    List<AccountListDTO> findAllAccount();

}
