package com.developer.chatapp.user;

import com.developer.chatapp.exceptions.BadRequestException;
import com.developer.chatapp.exceptions.NotFoundException;
import com.developer.chatapp.inbox.InboxEntity;
import com.developer.chatapp.inbox.InboxRepository;
import com.developer.chatapp.inbox.UserInboxDto;
import org.springframework.stereotype.Service;

@Service
public class UserBasicService {

    private final UserRepository userRepository;
    private final InboxRepository inboxRepository;

    public UserBasicService(UserRepository userRepository, InboxRepository inboxRepository) {
        this.userRepository = userRepository;
        this.inboxRepository = inboxRepository;
    }

    public UserDto register(UserDto userDto) {

        UserDtoValidator.validate(userDto);

        boolean exists = userRepository.existsByUsernameOrEmail(userDto.getUsername(), userDto.getEmail());
        if (exists) {
            throw new BadRequestException("User already exists by username/email");
        }

        UserEntity userEntity = new UserEntity(userDto);
        InboxEntity inboxEntity = new InboxEntity();

        inboxEntity.setUser(userEntity);
        inboxRepository.save(inboxEntity);
        inboxRepository.flush();

        userEntity.setInbox(inboxEntity);
        userRepository.save(userEntity);
        userRepository.flush();

        return new UserDto(userEntity);
    }


    public UserInboxDto get(String q) {

        UserEntity userEntity = userRepository.getByUsernameOrEmail(q, q);

        if (userEntity == null) {
            throw new NotFoundException("No user found against " + q);
        }

        return new UserInboxDto(userEntity);
    }
}
