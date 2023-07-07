package com.codegym.backend.repository;

import com.codegym.backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface IRepositoryMessage extends JpaRepository<Message,Integer> {
    @Query(value = "select * from message order by id desc",nativeQuery = true)
    List<Message> findMessage();
    @Query(value = "select * from message where id = ?",nativeQuery = true)
    Message findById(int id);
}
