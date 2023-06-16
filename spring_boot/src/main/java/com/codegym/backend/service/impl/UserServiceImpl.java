package com.codegym.backend.service.impl;

import com.codegym.backend.dto.IUserDTO;
import com.codegym.backend.repository.UserRepository;
import com.codegym.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public IUserDTO findUserById(int index) {
        return userRepository.getUserById(index);
    }
}
