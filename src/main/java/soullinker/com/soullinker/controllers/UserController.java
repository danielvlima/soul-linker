package soullinker.com.soullinker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soullinker.com.soullinker.dtos.CreateUserRequest;
import soullinker.com.soullinker.dtos.UserResponse;
import soullinker.com.soullinker.models.User;
import soullinker.com.soullinker.services.UserService;

import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable UUID userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest userRequest) {
        try {
            User createdUser = userService.registerNewUserAccount(userRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
