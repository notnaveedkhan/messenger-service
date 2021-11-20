package com.developer.chatapp.inbox;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InboxDto {

    private long id;
    private long userId;

    public InboxDto(InboxEntity inbox) {
        this.id = inbox.getId();
        this.userId = inbox.getUser().getId();
    }

}
