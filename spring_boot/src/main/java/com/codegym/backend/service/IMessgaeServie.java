package com.codegym.backend.service;

import com.codegym.backend.model.Message;

import java.util.List;

public interface IMessgaeServie {
    Message save(Message message);
    List<Message> findMessage();
    void deleteMessage(Message message);
    Message findById(int id);
}
