package com.codegym.backend.controller;


import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.dto.IUserInforDTO;
import com.codegym.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class UserResController {
    @Autowired
    private IUserService userService;

    @GetMapping("/find-user-id/{id}")
    public ResponseEntity<IUserInforDTO> findUserById(@PathVariable Integer id) {
        IUserInforDTO user = userService.findUserById(id);
        if (user == null) {
            return new ResponseEntity<IUserInforDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<IUserInforDTO>(user, HttpStatus.OK);
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
        Pageable pageable = PageRequest.of(0, 10);
        Page<IUserDto> userList = userService.findAll(pageable);
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài khoản cần xóa!");
        } else if (Objects.equals(userList.getContent().get(id-1).getEnableFlag(), "false")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài khoản cần xóa!");
        } else {
            userService.deleteById(id);
            return ResponseEntity.ok("Đã xóa thành công!");
        }
    }
}
