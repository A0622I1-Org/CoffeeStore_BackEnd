package com.codegym.backend.service;

import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserEditDTO;
import javax.mail.MessagingException;


public interface UserService {
    void editUser(UserEditDTO userEditDTO, int id);

    void createNewUser(UserDTO userDTO) throws MessagingException;

    Integer findByPhone(String phoneNumber);

    Integer findByUserName(String userName);

}
