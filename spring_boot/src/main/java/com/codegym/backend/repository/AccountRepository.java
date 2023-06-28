package com.codegym.backend.repository;

import com.codegym.backend.dto.AccountListDTO;
import com.codegym.backend.model.Account;
import com.codegym.backend.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUserName(String username);
    
    @Query(value = "select id from  a0622i1_coffee.account where user_name = ?1", nativeQuery = true)
    Integer findIdUserByUserName(String userName);

    @Query(value = "select * from a0622i1_coffee.account", nativeQuery = true)
    List<Account> getAllAccount();

    @Modifying
    @Query(value="update a0622i1_coffee.account set account.email = ?1 where account.id = ?2", nativeQuery = true)
    void updateEmailAccount(String email, Integer id);

    @Query(value="select a.id, a.email, a.user_name from a0622i1_coffee.account a ", nativeQuery =true)
    List<AccountListDTO> findAllAccount();
}