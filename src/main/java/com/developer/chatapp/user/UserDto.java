package com.developer.chatapp.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String username;
    private String email;
    private String name;

    public UserDto(UserEntity entity) {
        this.email = entity.getEmail();
        this.username = entity.getUsername();
        this.name = entity.getName();
    }

    public UserDto() { }
}
