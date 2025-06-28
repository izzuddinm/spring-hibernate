package com.izzuddinm.spring_hibernate.controller;

import com.izzuddinm.spring_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/generate")
    public String generateUsers(@RequestParam int total) {
        return userService.generateUsers(total);
    }

    @PostMapping("/index/create")
    public String createIndex() {
        return userService.createIndex();
    }

    @DeleteMapping("/index/drop")
    public String dropIndex() {
        return userService.dropIndex();
    }

    @GetMapping("/search")
    public String searchByEmail(@RequestParam String email) {
        return userService.searchByEmail(email);
    }
}
