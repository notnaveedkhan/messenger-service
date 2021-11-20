package com.developer.chatapp.inbox;

import com.developer.chatapp.conversation.ConversationEntity;
import com.developer.chatapp.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inbox")
@Getter
@Setter
public class InboxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity user;

    @JoinTable(
            name = "rel_inbox_conv",
            joinColumns = @JoinColumn(
                    name = "inbox_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "conv_id",
                    referencedColumnName = "id"
            )
    )
    @OneToMany
    private List<ConversationEntity> conversations;

}
