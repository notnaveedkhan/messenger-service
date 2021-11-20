package com.developer.chatapp.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity getByUsername(String username);
    UserEntity getByUsernameOrEmail(String username, String email);
    boolean existsByUsernameOrEmail(String username, String email);
    UserEntity getByEmail(String email);

}
