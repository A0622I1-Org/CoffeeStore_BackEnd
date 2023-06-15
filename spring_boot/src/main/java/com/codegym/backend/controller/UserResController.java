package com.codegym.backend.controller;

import com.codegym.backend.dto.FeedbackDetailDto;
import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.service.IFeedbackService;
import com.codegym.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class UserResController {
    @Autowired
    private IUserService userService;

    @GetMapping("/listUser")
    public ResponseEntity<Page<IUserDto>> getFeedbacklist(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<IUserDto> userList = userService.findAll(pageable);
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/getUserByNameOrBirthday")
    public ResponseEntity<Page<IUserDto>> getListByDate(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page, size);
        if (Objects.equals(date, "")) {
            Page<IUserDto> userList = userService.findUserByName(pageable, "%" + name + "%");
            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(userList);
        } else {
            Page<IUserDto> userList = userService.findUserByNameOrDate(pageable, date, "%" + name + "%");
            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(userList);
        }
    }

    @DeleteMapping("/userDelete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        if (!userService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tài khoản cần xóa!");
        } else {
            return ResponseEntity.ok("Đã xóa thành công!");
        }
    }
}
