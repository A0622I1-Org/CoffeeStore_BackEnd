package com.codegym.backend.service;

import com.codegym.backend.dto.IUserDTO;

public interface UserService {

    IUserDTO findUserById(int index);
}
