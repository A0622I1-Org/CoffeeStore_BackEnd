package com.codegym.backend.service;

import com.codegym.backend.dto.IUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<IUserDto> findUserByNameOrDate(Pageable pageable, String date, String name);
    Page<IUserDto> findAll(Pageable pageable);
    void deleteById(int id);
}
