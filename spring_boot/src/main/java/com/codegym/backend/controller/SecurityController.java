package com.codegym.backend.controller;

import com.codegym.backend.dto.AccountDTO;
import com.codegym.backend.payload.responce.MessageResponse;
import com.codegym.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {

    @Autowired
    AccountService accountService;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * ThangLV
     * change password
     */
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody AccountDTO accountDTO){

        if (accountService.authenticatePassword(accountDTO.getCurrentPassword(), accountDTO.getUserName())) {
            accountService.changePassword(encoder.encode(accountDTO.getNewPassword()),accountDTO.getUserName());
            return ResponseEntity.ok(new MessageResponse("Đổi mật khẩu thành công"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Mật khẩu không đúng"));
    }
}
