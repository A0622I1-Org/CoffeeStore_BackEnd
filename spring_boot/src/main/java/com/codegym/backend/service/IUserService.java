package com.codegym.backend.service;

import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.dto.IUserInforDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<IUserDto> findUserByNameOrDate(Pageable pageable, String date, String name);
    Page<IUserDto> findUserByName(Pageable pageable, String name);
    Page<IUserDto> findAll(Pageable pageable);
    void deleteById(int id);
    IUserInforDTO findUserById(int index);
    List<IUserDto> findAllUser();
}
