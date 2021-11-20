package com.developer.chatapp.user;

import com.developer.chatapp.inbox.UserInboxDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserBasicService userBasicService;

    public UserController(UserBasicService userBasicService) {
        this.userBasicService = userBasicService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        UserDto responseDto = userBasicService.register(userDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/")
    public ResponseEntity<UserInboxDto> get(@RequestParam(value = "") String q) {
        UserInboxDto userInboxDto = userBasicService.get(q);
        return ResponseEntity.ok(userInboxDto);
    }

}
