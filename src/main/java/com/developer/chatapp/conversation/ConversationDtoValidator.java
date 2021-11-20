package com.developer.chatapp.conversation;

import com.developer.chatapp.exceptions.BadRequestException;

public class ConversationDtoValidator {


    public static void validate(ConversationDto conversationDto) {

        if (conversationDto.getInitiator() == null) {
            throw new BadRequestException("Initiator is not set");
        }

        if (conversationDto.getInitiator().isEmpty()) {
            throw new BadRequestException("Initiator is empty");
        }

        if (conversationDto.getTitle() == null) {
            throw new BadRequestException("Title is not set");
        }

        if (conversationDto.getTitle().isEmpty()) {
            throw new BadRequestException("Title is empty");
        }

    }

}
