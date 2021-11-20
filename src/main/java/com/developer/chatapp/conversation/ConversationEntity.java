package com.developer.chatapp.conversation;

import com.developer.chatapp.inbox.InboxEntity;
import com.developer.chatapp.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation")
@Getter
@Setter
public class ConversationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @JoinTable(
            name = "rel_user_conv",
            joinColumns = @JoinColumn(name = "conv_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @ManyToMany
    private List<UserEntity> members;

}
