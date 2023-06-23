package com.codegym.backend.controller;

import com.codegym.backend.model.CoffeeTable;
import com.codegym.backend.model.Message;
import com.codegym.backend.service.IMessgaeServie;
import com.codegym.backend.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class WebsocketController {
    @Autowired
    IMessgaeServie iMessgaeServie;

    @Autowired
    ITableService iTableService;

    //    @MessageExceptionHandler()
    @MessageMapping("/messages")
    @SendTo("/topic/messages")
    public Message broadcastNews(Message mess) {
        return this.iMessgaeServie.save(mess);
    }

    @MessageMapping("/tables")
    @SendTo("/topic/table")
    public CoffeeTable updateTable(int id ) {
        return this.iTableService.updateTableStatus(id);
    }
}
