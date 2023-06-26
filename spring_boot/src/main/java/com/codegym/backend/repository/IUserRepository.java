package com.codegym.backend.repository;

import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.dto.IUserInforDTO;
import com.codegym.backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select user.id as id, user.name,account.user_name as userName, user.birthday as dateOfBirth, user.address, user.phone_number as phone,\n" +
            "        user.gender, user.salary, position.name as position, user.img_url as img from user\n" +
            "                         join position on position.id = user.position_id\n" +
            "                         join account on account.id = user.account_id where user.enable_flag =1 and user.id = ?", nativeQuery = true)
    IUserInforDTO getUserById(int index);

    String JOIN_ACCOUNT = "join account a on u.account_id = a.id\n";
    String SELECT_USER_ITEM = "select u.id, a.user_name account, u.name userName, u.address, u.phone_number PhoneNumber, u.gender, u.birthday, u.enable_flag enableFlag, u.salary, p.name position  from user u\n";
    String JOIN_POSITION = "join position p on p.id = u.position_id\n";
    String ORDER_BY = "order by u.id";

    String SELECT_ALL_USER_SQL = SELECT_USER_ITEM + JOIN_ACCOUNT + JOIN_POSITION + ORDER_BY;

    @Query(value = SELECT_ALL_USER_SQL, countQuery = SELECT_ALL_USER_SQL, nativeQuery = true)
    Page<IUserDto> findAllList(Pageable pageable);

    @Query(value = SELECT_ALL_USER_SQL, countQuery = SELECT_ALL_USER_SQL, nativeQuery = true)
    List<IUserDto> findAllUser();

    String FIND_NAME_AND_BIRTHDAY_SQL = SELECT_USER_ITEM + JOIN_ACCOUNT + JOIN_POSITION +
            "where u.birthday = ? and u.name like ? \n" +
            ORDER_BY;

    @Query(value = FIND_NAME_AND_BIRTHDAY_SQL, countQuery = FIND_NAME_AND_BIRTHDAY_SQL, nativeQuery = true)
    Page<IUserDto> findUserByNameOrDate(Pageable pageable, String date, String name);

    String FIND_NAME_SQL = SELECT_USER_ITEM +
            "u.salary, p.name position  from user u \n" + JOIN_ACCOUNT +
            "join position p on p.id = u.position_id\n" +
            "where u.name like ? \n" + ORDER_BY;

    @Query(value = FIND_NAME_SQL, countQuery = FIND_NAME_SQL, nativeQuery = true)
    Page<IUserDto> findUserByName(Pageable pageable, String date);

    @Modifying
    @Query(value = "update user set enable_flag = 0 where id = ?", nativeQuery = true)
    void deleteById(int id);
}
