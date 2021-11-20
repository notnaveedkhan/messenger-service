package com.developer.chatapp.user;

import com.developer.chatapp.exceptions.BadRequestException;

public class UserDtoValidator {


    public static void validate(UserDto dto) {

        if (dto.getUsername() == null) {
            throw new BadRequestException("Username is not set");
        }

        if (dto.getUsername().isEmpty()) {
            throw new BadRequestException("Username is empty");
        }

        if (dto.getEmail() == null) {
            throw new BadRequestException("Email is not set");
        }

        if (dto.getEmail().isEmpty()) {
            throw new BadRequestException("Email is empty");
        }

        if (dto.getName() == null) {
            throw new BadRequestException("Name is not set");
        }

        if (dto.getName().isEmpty()) {
            throw new BadRequestException("Name is empty");
        }

    }


}
