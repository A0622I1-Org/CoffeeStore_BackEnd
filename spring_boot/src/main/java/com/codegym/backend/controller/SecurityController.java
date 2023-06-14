package com.codegym.backend.controller;

import com.codegym.backend.jwt.JwtUtility;
import com.codegym.backend.model.Account;
import com.codegym.backend.model.User;
import com.codegym.backend.payload.request.LoginRequest;
import com.codegym.backend.payload.request.VerificationCodeRequest;
import com.codegym.backend.payload.response.JwtResponse;
import com.codegym.backend.payload.response.MessageResponse;
import com.codegym.backend.service.IAccountService;
import com.codegym.backend.service.IUserService;
import com.codegym.backend.service.impl.AccountDetail;
import com.codegym.backend.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {
    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IAccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtility.generateJwtToken(loginRequest.getUsername());
        AccountDetail accountDetail = (AccountDetail) authentication.getPrincipal();
        List<String> roles = accountDetail.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        Optional<Account> account = accountService.findAccountByUserName(loginRequest.getUsername());
        User user = userService.findByAccountId(account.get().getId(), false);
        if (user != null) {
            user.setAccount(null);
        }
        return ResponseEntity.ok(
                new JwtResponse(token, accountDetail.getId(), accountDetail.getUsername(), roles, user)
        );
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> reset(@Valid @RequestBody LoginRequest loginRequest) throws MessagingException, UnsupportedEncodingException {
        if (accountService.existsByUserName(loginRequest.getUsername()) != null) {
            accountService.addVerificationCode(loginRequest.getUsername());
            return ResponseEntity.ok(new MessageResponse("Sent email "));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không đúng"));
    }

    @PostMapping("/verify-change-password")
    public ResponseEntity<?> verifyPassword(@Valid @RequestBody VerificationCodeRequest verificationCodeRequest) {
        if (accountService.findAccountByVerificationCode(verificationCodeRequest.getCode()) != null) {
            return ResponseEntity.ok(new MessageResponse("Xác minh thành công"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Xác minh thất bại"));
    }
}
