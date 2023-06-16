package com.codegym.backend.service;

import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserEditDTO;
import com.codegym.backend.dto.UserFindIdDTO;

import javax.mail.MessagingException;
import java.util.List;


public interface UserService {

    UserFindIdDTO findById(int id);

    void editUser(UserEditDTO userEditDTO, int id);

    void createNewUser(UserDTO userDTO) throws MessagingException;

    Integer findByPhone(String phoneNumber);

    Integer findByUserName(String userName);

}
