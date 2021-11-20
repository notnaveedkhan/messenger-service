package com.developer.chatapp.inbox;

import org.springframework.stereotype.Service;

@Service
public class InboxService {

    private final InboxRepository inboxRepository;

    public InboxService(InboxRepository inboxRepository) {
        this.inboxRepository = inboxRepository;
    }



}
