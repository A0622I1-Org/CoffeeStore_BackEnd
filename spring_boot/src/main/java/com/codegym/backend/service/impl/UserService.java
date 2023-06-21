package com.codegym.backend.service.impl;

import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.model.User;
import com.codegym.backend.repository.IAccountRepository;
import com.codegym.backend.repository.IUserRepository;
import com.codegym.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAllUser() {
        return repository.findAllUser();
    }

    @Override
    public User findByAccountId(int accountId, Boolean enableFlag) {
        return repository.findByAccountId(accountId,enableFlag);
    }

    @Override
    public String findNameByAccountId(int accountId, Boolean enableFlag) {
        return repository.findNameByAccountId(accountId,enableFlag);
    }

    @Override
    public Page<IUserDto> findUserByNameOrDate(Pageable pageable, String date, String name) {
        return repository.findUserByNameOrDate(pageable, date, name);
    }

    @Override
    public Page<IUserDto> findUserByName(Pageable pageable, String name) {
        return repository.findUserByName(pageable, name);
    }

    @Override
    public Page<IUserDto> findAll(Pageable pageable) {
        return repository.findAllList(pageable);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
