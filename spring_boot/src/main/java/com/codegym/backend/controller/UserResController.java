package com.codegym.backend.controller;


import com.codegym.backend.dto.AccountListDTO;
import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserEditDTO;
import com.codegym.backend.dto.UserFindIdDTO;

import com.codegym.backend.model.Position;
import com.codegym.backend.service.AccountService;
import com.codegym.backend.service.PositionService;
import com.codegym.backend.service.UserService;
import com.codegym.backend.validation.UserCreateByRequestDtoValidator;
import com.codegym.backend.validation.UserEditByRequestDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class UserResController {
    @Autowired
    private IUserService iuserService;
    @Autowired
    private UserService userService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserCreateByRequestDtoValidator userCreateByRequestDtoValidator;
    @Autowired
    private UserEditByRequestDtoValidator userEditByRequestDtoValidator;

    String currentEmail = null;
    String currentPhoneNumber = null;


    @PutMapping("/edit-user/{id}")
    public ResponseEntity<?> editUser(@Valid @RequestBody UserEditDTO userEditDTO, BindingResult
            bindingResult, @PathVariable int id) throws MessagingException {
        userEditDTO.setCurrentEmail(this.currentEmail);
        userEditDTO.setCurrentPhoneNumber(this.currentPhoneNumber);
        System.out.println(userEditDTO.getCurrentEmail());
        userEditByRequestDtoValidator.validate(userEditDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        userService.editUser(userEditDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> createNewUser() {
        List<Position> positionList = positionService.getAllPosition();
        List<Object> list = Arrays.asList(positionList);
        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ResponseEntity<?> createNewUser(@Valid @RequestBody UserDTO userDTO, BindingResult
            bindingResult) throws MessagingException {
        userCreateByRequestDtoValidator.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        System.out.println(userDTO.toString());
        userService.createNewUser(userDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = positionService.getAllPosition();
        if (positionList.isEmpty()) {
            return new ResponseEntity<List<Position>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Position>>(positionList, HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<List<AccountListDTO>> getAllAccounts() {
        return new ResponseEntity<List<AccountListDTO>>(accountService.findAllAccount(), HttpStatus.OK);
    }


    @GetMapping("/find-id/{id}")
    public ResponseEntity<UserFindIdDTO> getById(@PathVariable Integer id) {
        System.out.println(id);
        UserFindIdDTO user = userService.getById(id);
        this.currentEmail = user.getEmail();
        this.currentPhoneNumber = user.getPhoneNumber();
        if (user == null) {
            return new ResponseEntity<UserFindIdDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<UserFindIdDTO>(user, HttpStatus.OK);
    }


    @GetMapping("/listUser")
    public ResponseEntity<Page<IUserDto>> getUserlist(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<IUserDto> userList = iuserService.findAll(pageable);
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
            userList = iuserService.findUserByName(pageable, "%" + name + "%");
        } else {
            userList = iuserService.findUserByNameOrDate(pageable, date, "%" + name + "%");
        }
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/userDelete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        Pageable pageable = PageRequest.of(0, 10);
        Page<IUserDto> userList = iuserService.findAll(pageable);
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài khoản cần xóa!");
        } else if (Objects.equals(userList.getContent().get(id-1).getEnableFlag(), "false")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài khoản cần xóa!");
        } else {
            iuserService.deleteById(id);
            return ResponseEntity.ok("Đã xóa thành công!");
        }
    }
}
