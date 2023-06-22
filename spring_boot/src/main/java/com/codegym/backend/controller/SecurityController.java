package com.codegym.backend.controller;

import com.codegym.backend.dto.AccountDTO;
import com.codegym.backend.payload.request.LoginRequest;
import com.codegym.backend.payload.request.NewPasswordRequest;
import com.codegym.backend.payload.request.VerificationCodeRequest;
import com.codegym.backend.payload.response.MessageResponse;
import com.codegym.backend.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.codegym.backend.jwt.JwtUtility;
import com.codegym.backend.model.Account;
import com.codegym.backend.model.User;
import com.codegym.backend.payload.response.JwtResponse;
import com.codegym.backend.service.IUserService;
import com.codegym.backend.service.impl.AccountDetail;
import com.codegym.backend.service.impl.RoleService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

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
    AccountService accountService;
    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    IUserService userService;
    @Autowired
    private PasswordEncoder encoder;

    /**
     * ThangLV
     * change password
     */
    @PostMapping("/change-password-request")
    public ResponseEntity<?> changePassword(@RequestBody AccountDTO accountDTO) {

        if (accountService.authenticatePassword(accountDTO.getCurrentPassword(), accountDTO.getUserName())) {
            accountService.changePassword(encoder.encode(accountDTO.getNewPassword()), accountDTO.getUserName());
            return ResponseEntity.ok(new MessageResponse("Đổi mật khẩu thành công"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Mật khẩu không đúng"));
    }


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

    //Kiểm tra đường dẫn xác thực của Email có chính xác không
    @PostMapping("/verify-change-password")
    public ResponseEntity<?> verifyPassword(@Valid @RequestBody VerificationCodeRequest verificationCodeRequest) {
        if (accountService.findAccountByVerificationCode(verificationCodeRequest.getCode()) != null) {
            return ResponseEntity.ok(new MessageResponse("Xác minh thành công"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Xác minh thất bại"));
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> doChangePassword(@RequestBody NewPasswordRequest newPasswordRequest) {
        if (accountService.findAccountByVerificationCode(newPasswordRequest.getCode()) != null) {
            accountService.saveNewPassword(passwordEncoder.encode(newPasswordRequest.getNewPassword()), newPasswordRequest.getCode());
            return ResponseEntity.ok(new MessageResponse("Thay đổi mật khẩu thành công"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Thay đổi mật khẩu thất bại"));
    }
}
