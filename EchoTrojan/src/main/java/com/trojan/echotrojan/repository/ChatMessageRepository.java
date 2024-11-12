package com.trojan.echotrojan.repository;

import com.trojan.echotrojan.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}