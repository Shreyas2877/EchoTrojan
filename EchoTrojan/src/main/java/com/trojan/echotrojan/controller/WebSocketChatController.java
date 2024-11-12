package com.trojan.echotrojan.controller;

import com.trojan.echotrojan.dto.ChatMessageDTO;
import com.trojan.echotrojan.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDTO sendMessage(ChatMessageDTO chatMessageDTO) {
        // Save the message to the database
        chatMessageService.saveMessage(chatMessageDTO);
        return chatMessageDTO;
    }
}