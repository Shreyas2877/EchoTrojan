package com.trojan.echotrojan.service;

import com.trojan.echotrojan.dto.ChatMessageDTO;
import com.trojan.echotrojan.model.ChatMessage;
import com.trojan.echotrojan.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessageDTO chatMessageDTO) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setId(UUID.randomUUID().toString());
        chatMessage.setSenderId(chatMessageDTO.getSenderId());
        chatMessage.setSenderName(chatMessageDTO.getSenderName());
        chatMessage.setContent(chatMessageDTO.getContent());
        chatMessage.setTimestamp(LocalDateTime.now());

        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessageDTO> getAllMessages() {
        List<ChatMessage> chatMessages = chatMessageRepository.findAll();
        return chatMessages.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ChatMessageDTO convertToDTO(ChatMessage chatMessage) {
        ChatMessageDTO chatMessageDTO = new ChatMessageDTO();
        chatMessageDTO.setSenderId(chatMessage.getSenderId());
        chatMessageDTO.setSenderName(chatMessage.getSenderName());
        chatMessageDTO.setContent(chatMessage.getContent());
        chatMessageDTO.setTimestamp(chatMessage.getTimestamp());
        return chatMessageDTO;
    }
}