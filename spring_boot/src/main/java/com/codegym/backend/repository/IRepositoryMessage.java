package com.codegym.backend.repository;

import com.codegym.backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IRepositoryMessage extends JpaRepository<Message,Integer> {
    @Query(value = "select * from message",nativeQuery = true)
    List<Message> findMessage();
    @Query(value = "select * from message where id = ?",nativeQuery = true)
    Message findById(int id);
}
