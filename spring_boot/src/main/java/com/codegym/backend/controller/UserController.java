package com.codegym.backend.controller;

import com.codegym.backend.dto.IUserDTO;
import com.codegym.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/public")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/find-user-id/{id}")
    public ResponseEntity<IUserDTO> findUserById(@PathVariable Integer id) {
        IUserDTO user = userService.findUserById(id);
        if (user == null) {
            return new ResponseEntity<IUserDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<IUserDTO>(user, HttpStatus.OK);
    }
}
