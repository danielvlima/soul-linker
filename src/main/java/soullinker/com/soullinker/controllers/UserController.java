package soullinker.com.soullinker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    interface User {
        String getName();
    }
    @GetMapping("/user")
    public User getUser() {
        return new User() {
            @Override
            public String getName() {
                return "usuario padrao";
            }
        };
    }
}
