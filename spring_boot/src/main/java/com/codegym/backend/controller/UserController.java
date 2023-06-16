package com.codegym.backend.controller;


import com.codegym.backend.dto.UserEditDTO;
import com.codegym.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/edit-user/{id}")
    public ResponseEntity<?> editUser(@RequestBody UserEditDTO userEditDTO, @PathVariable int id) {
        userService.editUser(userEditDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
