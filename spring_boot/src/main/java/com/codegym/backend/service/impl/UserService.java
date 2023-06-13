package com.codegym.backend.service.impl;

import com.codegym.backend.model.User;
import com.codegym.backend.repository.IAccountRepository;
import com.codegym.backend.repository.IUserRepository;
import com.codegym.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public User findByAccountId(int accountId, Boolean enableFlag) {
        return userRepository.findByAccountId(accountId,enableFlag);
    }

    @Override
    public String findNameByAccountId(int accountId, Boolean enableFlag) {
        return userRepository.findNameByAccountId(accountId,enableFlag);
    }
}
