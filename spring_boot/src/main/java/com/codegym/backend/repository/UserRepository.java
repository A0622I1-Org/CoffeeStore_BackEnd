package com.codegym.backend.repository;

import com.codegym.backend.dto.UserFindIdDTO;
import com.codegym.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    
    @Modifying
    @Query(value = "update user as u set u.name = ?1, u.address = ?2, u.phone_number = ?3, u.birthday = ?4, u.gender = ?5," +
            " u.salary = ?6, u.account_id = ?7, u.img_url = ?8, u.position_id = ?9 where u.id = ?10", nativeQuery = true)
    void editUser(String name,String address,String phoneNumber,String birthday,int gender,Double salary,int account,String imgUrl,int position,int id);


    @Modifying
    @Query(value = "INSERT INTO user (name, address, phone_number, birthday, gender, salary, img_url, position_id,account_id, enable_flag)" +
            " values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    void createNewUser(String name,String address,String phoneNumber,String birthday,Integer gender,Double salary,String imgUrl,Integer position,Integer account,Boolean enableFlag);


    @Query(value = "select count(phone_number) from user where phone_number = ?", nativeQuery = true)
    Integer findByPhone(String phoneNumber);


    @Query(value = "select user.id , user.name, user.birthday,user.gender,user.salary,user.img_url, " +
            "user.address, user.phone_number, user.position_id, user.account_id from user inner join position as p on p.id = user.position_id " +
            "inner join account as a on a.id = user.account_id " +
            "where user.id = ?1", nativeQuery = true)
    UserFindIdDTO getById(int id);




}

