package com.codegym.backend.controller;

import com.codegym.backend.dto.AccountDTO;
import com.codegym.backend.dto.IUserDto;

import com.codegym.backend.dto.IUserInforDTO;
import com.codegym.backend.payload.response.MessageResponse;

import com.codegym.backend.service.IUserService;
import com.codegym.backend.service.impl.AccountDetailServiceImpl;
import com.codegym.backend.service.impl.AccountService;
import com.codegym.backend.validation.PasswordChangeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class UserResController {
    @Autowired
    private IUserService userService;
    @Autowired
    AccountService accountService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AccountDetailServiceImpl accountDetailService;
    @Autowired
    private PasswordChangeValidator passwordChangeValidator;

    /**
     * ThangLV
     * get information of User by idUser
     */
    @GetMapping("/find-user-infor")
    public ResponseEntity<IUserInforDTO> findUserInformation() {
        String username = accountDetailService.getCurrentUserName();
        IUserInforDTO user = userService.findUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * ThangLV
     * validation password, check password and change password
     */
    @PostMapping("/change-password-request")
    public ResponseEntity<?> changePassword(@RequestBody AccountDTO accountDTO, BindingResult
            bindingResult) throws MessagingException{
        passwordChangeValidator.validate(accountDTO, bindingResult);
        String username = accountDetailService.getCurrentUserName();
        accountDTO.setUserName(username);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        if (accountService.checkPassword(accountDTO.getCurrentPassword(), accountDTO.getUserName())) {
            accountService.changePassword(encoder.encode(accountDTO.getNewPassword()), accountDTO.getUserName());
            return ResponseEntity.ok(new MessageResponse("Đổi mật khẩu thành công"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Mật khẩu hiện tại không đúng"));
    }

    @GetMapping("/listUser")
    public ResponseEntity<Page<IUserDto>> getUserlist(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<IUserDto> userList = userService.findAll(pageable);
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/getUserByNameOrBirthday")
    public ResponseEntity<Page<IUserDto>> getListByNameOrDate(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page, size);
        Page<IUserDto> userList;
        if (Objects.equals(date, "")) {
            userList = userService.findUserByName(pageable, "%" + name + "%");
        } else {
            userList = userService.findUserByNameOrDate(pageable, date, "%" + name + "%");
        }
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/userDelete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        List<IUserDto> userList = userService.findAllUser();
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài khoản cần xóa!");
        } else if (Objects.equals(userList.get(id-1).getEnableFlag(), "false")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài khoản cần xóa!");
        } else {
            userService.deleteById(id);
            return ResponseEntity.ok("Đã xóa thành công!");
        }
    }
}
