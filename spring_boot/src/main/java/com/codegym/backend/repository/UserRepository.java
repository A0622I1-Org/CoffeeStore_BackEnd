package com.codegym.backend.repository;

import com.codegym.backend.dto.UserFindIdDTO;
import com.codegym.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "update user as u set u.name = ?1, u.address = ?2, u.phone_number = ?3, u.birthday = ?4, u.gender = ?5," +
            " u.salary = ?6, u.img_url = ?7, u.position_id = ?8 where u.id = ?9", nativeQuery = true)
    void editUser(String name,String address,String phoneNumber,String birthday,int gender,Double salary,String imgUrl,int position,int id);


    @Modifying
    @Query(value = "INSERT INTO user (name, address, phone_number, birthday, gender, salary, img_url, position_id,account_id, enable_flag)" +
            " values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    void createNewUser(String name,String address,String phoneNumber,String birthday,Integer gender,Double salary,String imgUrl,Integer position,Integer account,Boolean enableFlag);


    @Query(value = "select count(phone_number) from user where phone_number = ?", nativeQuery = true)
    Integer findByPhone(String phoneNumber);

    @Query(value = "select count(user_name) from account where user_name = :userName ", nativeQuery = true)
    Integer findByUserName(@Param("userName") String userName);

    @Query(value = "select count(email) from account where email = :email ", nativeQuery = true)
    Integer findByEmail(@Param("email") String email);

    @Query(value = "select user.id , a.user_name as username, user.name ,user.img_url as imgUrl, a.email, user.gender, user.birthday,user.address , user.phone_number as phoneNumber\n" +
            "            , user.position_id as position, user.salary from user \n" +
            "            inner join position as p on p.id = user.position_id \n" +
            "            inner join account as a on a.id = user.account_id \n" +
            "            where user.id = ?", nativeQuery = true)
    UserFindIdDTO getById(int id);



}

