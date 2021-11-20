package com.developer.chatapp.user;

import com.developer.chatapp.inbox.InboxEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private InboxEntity inbox;

    public UserEntity() {

    }

    public UserEntity(UserDto userDto) {
        this.username = userDto.getUsername();
        this.email = userDto.getEmail();
        this.name = userDto.getName();
    }

}
