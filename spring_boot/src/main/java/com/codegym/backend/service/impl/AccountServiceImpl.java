package com.codegym.backend.service.impl;

import com.codegym.backend.repository.IAccountRepository;
import com.codegym.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    IAccountRepository IAccountRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * ThangLV
     * authenticate Account
     */
    @Override
    public Boolean authenticatePassword(String password, String username) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        if (authentication.isAuthenticated()) {
            return true;
        }
        return false;
    }

    /**
     * ThangLV
     * change password
     */
    @Override
    public void changePassword(String password, String username) {
        IAccountRepository.changePassword(password, username);
    }
}
