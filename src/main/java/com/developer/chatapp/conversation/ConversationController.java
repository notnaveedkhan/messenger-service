package com.developer.chatapp.conversation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversation")
public class ConversationController {

    private final ConversationBasicService conversationBasicService;

    public ConversationController(ConversationBasicService conversationBasicService) {
        this.conversationBasicService = conversationBasicService;
    }

    @PostMapping("/create")
    public ResponseEntity<ConversationDto> createConversation(
            @RequestBody ConversationDto conversationDto) {
        conversationDto = conversationBasicService.createConversation(conversationDto);
        return ResponseEntity.ok(conversationDto);
    }

}
