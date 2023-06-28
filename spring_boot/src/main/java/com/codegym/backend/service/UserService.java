package com.codegym.backend.service;

import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserEditDTO;
import com.codegym.backend.dto.UserFindIdDTO;

import javax.mail.MessagingException;


public interface UserService {
    UserFindIdDTO getById(int id);

    void editUser(UserEditDTO userEditDTO, int id) throws MessagingException ;

    void createNewUser(UserDTO userDTO) throws MessagingException;

    Integer findByPhone(String phoneNumber);

    Integer findByUserName(String userName);

    Integer findByEmail(String email);

}
