package com.codegym.backend.service;

import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();
    User findByAccountId(int accountId, Boolean enableFlag);
    String findNameByAccountId(int accountId, Boolean enableFlag);
    Page<IUserDto> findUserByNameOrDate(Pageable pageable, String date, String name);
    Page<IUserDto> findUserByName(Pageable pageable, String name);
    Page<IUserDto> findAll(Pageable pageable);
    void deleteById(int id);
}
