package com.codegym.backend.service;

import com.codegym.backend.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();
    User findByAccountId(int accountId, Boolean enableFlag);
    String findNameByAccountId(int accountId, Boolean enableFlag);
}
