package com.codegym.backend.service.impl;

import com.codegym.backend.dto.AccountListDTO;
import com.codegym.backend.model.Account;
import com.codegym.backend.repository.IAccountRepository;
import com.codegym.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    IAccountRepository IAccountRepository;

    @Override
    public Integer findIdUserByUserName(String userName) {
        return IAccountRepository.findIdUserByUserName(userName);
    }

    @Override
    public void addNew(Account account) {
        IAccountRepository.save(account);
    }

    @Override
    public void updateEmailAccount(String email, String username) {
        IAccountRepository.updateEmailAccount(email, username);
    }

    @Override
    public List<AccountListDTO> findAllAccount() {
        return IAccountRepository.findAllAccount();
    }


}
