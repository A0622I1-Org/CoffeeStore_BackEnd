package com.codegym.backend.service;

import com.codegym.backend.model.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

public interface IAccountService {

    Optional<Account> findAccountByUserName(String username);

    Integer findIdByUserName(String username);

    String existsByUserName(String username);

    String existsByEmail(String email);

    void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException;

    void sendVerificationEmailForResetPassWord(String name, String randomCode, String email) throws MessagingException, UnsupportedEncodingException;

    Account findAccountByVerificationCode(String code);
}
