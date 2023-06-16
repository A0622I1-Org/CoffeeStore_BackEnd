package com.codegym.backend.service.impl;

import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserEditDTO;
import com.codegym.backend.dto.UserFindIdDTO;

import com.codegym.backend.model.Account;
import com.codegym.backend.repository.UserRepository;
import com.codegym.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class UserServiceImpl implements UserService {
//    @Bean
//    public PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private AccoutService accoutService;


    @Override
    public UserFindIdDTO findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void editUser(UserEditDTO userEditDTO, int id) {
        userRepository.editUser(userEditDTO.getName(), userEditDTO.getAddress(), userEditDTO.getPhoneNumber(), userEditDTO.getBirthday(),
                userEditDTO.getGender(), userEditDTO.getSalary(), Integer.parseInt(userEditDTO.getAccount()), userEditDTO.getImgUrl(),
                Integer.parseInt(userEditDTO.getPosition()), id);
    }

    @Override
    public void createNewUser(UserDTO userDTO) throws MessagingException {
//        userRepository.createNewUser(userDTO.getName(), userDTO.getAddress(), userDTO.getPhoneNumber(), userDTO.getBirthday(),
//                userDTO.getGender(), userDTO.getSalary(), userDTO.getAccount(), userDTO.getImgUrl(), userDTO.getPosition(),false);
//        Account account = new Account();
//        account.setUserName(userDTO.getPhoneNumber());
//        account.setPassword(passwordEncoder.encode("123"));
//        account.setEnableFlag(true);
//        accountService.addNew(employeeDto.getIdCard(), encoder.encode("123"));
//        int id = accountService.findIdUserByUserName(employeeDto.getIdCard());
//        roleService.setDefaultRole(id, employeeDto.getAccount());
    }

    @Override
    public Integer findByPhone(String phoneNumber) {
        return userRepository.findByPhone(phoneNumber);
    }

    @Override
    public Integer findByUserName(String userName) {
        return null;
    }



}
