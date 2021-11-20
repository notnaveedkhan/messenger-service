package com.developer.chatapp.conversation;

import com.developer.chatapp.exceptions.NotFoundException;
import com.developer.chatapp.inbox.InboxEntity;
import com.developer.chatapp.inbox.InboxRepository;
import com.developer.chatapp.user.UserEntity;
import com.developer.chatapp.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationBasicService {

    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;
    private final InboxRepository inboxRepository;

    public ConversationBasicService(ConversationRepository conversationRepository,
                                    UserRepository userRepository,
                                    InboxRepository inboxRepository) {
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
        this.inboxRepository = inboxRepository;
    }


    public ConversationDto createConversation(ConversationDto conversationDto) {

        ConversationDtoValidator.validate(conversationDto);

        UserEntity initiator;

        // checking if user exists or not

        initiator = userRepository.getByUsernameOrEmail(conversationDto.getInitiator(),
                conversationDto.getInitiator());
        if (initiator == null) {
            throw new NotFoundException("Failed to find initiator");
        }

        // checking if users are already in conversation

        ConversationEntity conversation = new ConversationEntity();
        conversation.setTitle(conversationDto.getTitle());
//        conversation.setInbox(initiator.getInbox());

        List<UserEntity> members = conversation.getMembers();
        members.add(initiator);
        conversation.setMembers(members);
        conversationRepository.save(conversation);

        InboxEntity inbox = initiator.getInbox();
        List<ConversationEntity> conversations = inbox.getConversations();
        conversations.add(conversation);
        inbox.setConversations(conversations);
        inboxRepository.save(inbox);

        return null;
    }
}
