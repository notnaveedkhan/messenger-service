package com.developer.chatapp.inbox;

import com.developer.chatapp.user.UserDto;
import com.developer.chatapp.user.UserEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserInboxDto extends UserDto {

    private InboxDto inbox;

    public UserInboxDto(UserEntity entity) {
        super(entity);
        this.inbox = new InboxDto(entity.getInbox());
    }

}
