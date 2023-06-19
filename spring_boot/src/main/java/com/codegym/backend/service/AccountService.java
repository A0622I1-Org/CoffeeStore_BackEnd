package com.codegym.backend.service;

public interface AccountService {

    Boolean authenticatePassword(String password, String username);
    void changePassword(String password, String username);
}
