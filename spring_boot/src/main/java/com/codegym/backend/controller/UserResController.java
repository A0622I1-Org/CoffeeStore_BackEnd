package com.codegym.backend.controller;


import com.codegym.backend.dto.AccountListDTO;
import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserEditDTO;
import com.codegym.backend.dto.UserFindIdDTO;
import com.codegym.backend.model.Account;
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

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class UserResController {

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


    @PutMapping("/edit-user/{id}")
    public ResponseEntity<?> editUser(@Valid @RequestBody UserEditDTO userEditDTO, BindingResult
            bindingResult, @PathVariable int id) throws MessagingException {
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
        if (user == null) {
            return new ResponseEntity<UserFindIdDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<UserFindIdDTO>(user, HttpStatus.OK);
    }

}
