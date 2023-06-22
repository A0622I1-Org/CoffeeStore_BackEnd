package com.codegym.backend.service.impl;

import com.codegym.backend.dto.AccountListDTO;
import com.codegym.backend.model.Account;
import com.codegym.backend.repository.AccountRepository;
import com.codegym.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Integer findIdUserByUserName(String userName) {
        return accountRepository.findIdUserByUserName(userName);
    }

    @Override
    public void addNew(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void updateEmailAccount(String email, Integer account) {
        accountRepository.updateEmailAccount(email, account);
    }

    @Override
    public List<AccountListDTO> findAllAccount() {
        return accountRepository.findAllAccount();
    }


}
