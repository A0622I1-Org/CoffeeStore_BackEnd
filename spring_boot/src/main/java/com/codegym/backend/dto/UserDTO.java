package com.codegym.backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Integer id;
    String name;
    String address;
    String phoneNumber;
    String birthday;
    Integer gender;
    Double salary;
    Integer account;
    String imgUrl;
    Integer position;
}
