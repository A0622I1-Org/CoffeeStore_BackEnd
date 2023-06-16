package com.codegym.backend.repository;

import com.codegym.backend.dto.IUserDTO;
import com.codegym.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select user.id as id, user.name,account.user_name as userName, user.birthday as dateOfBirth, user.address, user.phone_number as phone,\n" +
            "        user.gender, user.salary, position.name as position, user.img_url as img from user\n" +
            "                         join position on position.id = user.position_id\n" +
            "                         join account on account.id = user.account_id where user.enable_flag =1 and user.id = ?", nativeQuery = true)
    IUserDTO getUserById(int index);
}
