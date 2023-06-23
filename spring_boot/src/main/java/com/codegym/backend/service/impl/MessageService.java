package com.codegym.backend.service.impl;

import com.codegym.backend.model.Message;
import com.codegym.backend.repository.IRepositoryMessage;
import com.codegym.backend.service.IMessgaeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessgaeServie {
    @Autowired
    IRepositoryMessage iRepositoryMessage;

    @Override
    public Message save(Message message) {
       return this.iRepositoryMessage.save(message);
    }

    @Override
    public List<Message> findMessage() {
        return this.iRepositoryMessage.findMessage();
    }

    @Override
    public void deleteMessage(Message message) {
        this.iRepositoryMessage.delete(message);
    }

    @Override
    public Message findById(int id) {
        return iRepositoryMessage.findById(id);
    }
}
