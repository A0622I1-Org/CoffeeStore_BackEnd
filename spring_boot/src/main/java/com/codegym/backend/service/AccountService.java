package com.codegym.backend.service;


import com.codegym.backend.dto.AccountListDTO;
import com.codegym.backend.model.Account;

import java.util.List;

public interface AccountService {

    Integer findIdUserByUserName(String username);

    void addNew(Account account);

    void updateEmailAccount(String email, Integer account);

    List<AccountListDTO> findAllAccount();

}

