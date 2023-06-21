package com.codegym.backend.service;

public interface AccountService {

    /**
     * ThangLV
     * authenticate Account
     */
    Boolean authenticatePassword(String password, String username);

    /**
     * ThangLV
     * change password
     */
    void changePassword(String password, String username);
}
