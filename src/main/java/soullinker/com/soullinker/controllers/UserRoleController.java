package soullinker.com.soullinker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soullinker.com.soullinker.dtos.CreateRoleRequest;
import soullinker.com.soullinker.services.UserRoleService;

@RestController
@RequestMapping(path = "/role")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<?> createUserRole(@RequestBody CreateRoleRequest role) {
        try {
            userRoleService.createRole(role);
            return ResponseEntity.status(HttpStatus.CREATED).body(role);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
