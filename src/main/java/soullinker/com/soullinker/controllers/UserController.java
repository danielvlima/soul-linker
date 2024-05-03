package soullinker.com.soullinker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soullinker.com.soullinker.dtos.UserRequest;
import soullinker.com.soullinker.models.User;
import soullinker.com.soullinker.services.UserService;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable UUID userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
