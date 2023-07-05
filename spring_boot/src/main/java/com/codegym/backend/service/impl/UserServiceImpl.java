package com.codegym.backend.service.impl;

import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserEditDTO;
import com.codegym.backend.dto.UserFindIdDTO;
import com.codegym.backend.model.Account;
import com.codegym.backend.repository.UserRepository;
import com.codegym.backend.service.AccountService;
import com.codegym.backend.service.RoleService;
import com.codegym.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public UserFindIdDTO getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void editUser(UserEditDTO userEditDTO, int id) throws MessagingException  {
        userRepository.editUser(
                userEditDTO.getName(),
                userEditDTO.getAddress(),
                userEditDTO.getPhoneNumber(),
                userEditDTO.getBirthday(),
                userEditDTO.getGender(),
                userEditDTO.getSalary(),
                userEditDTO.getImgUrl(),
                userEditDTO.getPosition(),
                id);
        accountService.updateEmailAccount(userEditDTO.getEmail(),userEditDTO.getUsername());
    }

    @Override
    public void createNewUser(UserDTO userDTO) throws MessagingException {
        Account account = new Account();
        account.setUserName(userDTO.getUserName());
        account.setPassword(passwordEncoder.encode("ABCabc@"));
        account.setEmail(userDTO.getEmail());
        account.setEnableFlag(true);
        String now = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        account.setChangePassworDate(now);
        accountService.addNew(account);
        Integer id = accountService.findIdUserByUserName(userDTO.getUserName());
        roleService.setDefaultRole(id, 1);
        userRepository.createNewUser(userDTO.getName(), userDTO.getAddress(), userDTO.getPhoneNumber(),
                userDTO.getBirthday(), userDTO.getGender(), userDTO.getSalary(), userDTO.getImgUrl(), userDTO.getPosition(),id,false);
    }

    @Override
    public Integer findByPhone(String phoneNumber) {
        return userRepository.findByPhone(phoneNumber);
    }

    @Override
    public Integer findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Integer findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
