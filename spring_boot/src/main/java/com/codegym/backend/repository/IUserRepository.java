package com.codegym.backend.repository;

import com.codegym.backend.dto.IUserDto;
import com.codegym.backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    String selectAllUser_sql = "select u.id, a.user_name account, u.name userName, u.address, u.phone_number PhoneNumber, u.gender, u.birthday,\n" +
            "u.salary, p.name position  from user u \n" +
            "join account a on u.account_id = a.id\n" +
            "join position p on p.id = u.position_id\n" +
            "order by u.id";
    @Query(value = selectAllUser_sql, countQuery = selectAllUser_sql, nativeQuery = true)
    Page<IUserDto> findAllList(Pageable pageable);

    String findNameOrBirthDay_sql = "select u.id, a.user_name account, u.name userName, u.address, u.phone_number PhoneNumber, u.gender, u.birthday,\n" +
            "u.salary, p.name position  from user u \n" +
            "join account a on u.account_id = a.id\n" +
            "join position p on p.id = u.position_id\n" +
            "where u.birthday = ? and u.name like ? \n" +
            "order by u.id";
    @Query(value = findNameOrBirthDay_sql, countQuery = findNameOrBirthDay_sql, nativeQuery = true)
    Page<IUserDto> findUserByNameOrDate(Pageable pageable, String date, String name);

    String findByName_sql = "select u.id, a.user_name account, u.name userName, u.address, u.phone_number PhoneNumber, u.gender, u.birthday,\n" +
            "u.salary, p.name position  from user u \n" +
            "join account a on u.account_id = a.id\n" +
            "join position p on p.id = u.position_id\n" +
            "where u.name like ? \n" +
            "order by u.id";
    @Query(value = findByName_sql, countQuery = findByName_sql, nativeQuery = true)
    Page<IUserDto> findUserByName(Pageable pageable, String date);

    @Modifying
    @Query(value = "call sp_deleteUser(?);", nativeQuery = true)
    int deleteById(int id);
}
