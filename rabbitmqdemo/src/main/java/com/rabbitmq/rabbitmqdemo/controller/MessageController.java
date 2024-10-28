package com.rabbitmq.rabbitmqdemo.controller;


import com.rabbitmq.rabbitmqdemo.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private MessageSender messageSender;

    @PostMapping("/send")
    public String send(@RequestParam String exchange, @RequestParam String routingKey, @RequestBody String message) {
        messageSender.sendMessage(exchange, routingKey, message);
        return "Message sent!";
    }
}
