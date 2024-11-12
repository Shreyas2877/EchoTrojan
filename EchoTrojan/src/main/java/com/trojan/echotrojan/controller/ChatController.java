package com.trojan.echotrojan.controller;

import com.trojan.echotrojan.dto.ChatMessageDTO;
import com.trojan.echotrojan.model.ChatMessage;
import com.trojan.echotrojan.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

//    @PostMapping("/message")
//    public ChatMessage receiveMessage(@RequestBody ChatMessageDTO chatMessageDTO) {
//        return chatMessageService.saveMessage(chatMessageDTO);
//    }

    @GetMapping("/messages")
    public List<ChatMessageDTO> getAllMessages() {
        return chatMessageService.getAllMessages();
    }
}