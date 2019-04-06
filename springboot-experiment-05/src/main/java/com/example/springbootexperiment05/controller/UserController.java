package com.example.springbootexperiment05.controller;

import com.example.springbootexperiment05.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/index")
    public Map getIndex() {
        return Map.of("index", "main");
    }

    @GetMapping("/users")
    public Map getUsers() {
        return Map.of("users", users);
    }

    @GetMapping("/users/{uid}")
    public Map getUser(@PathVariable int uid) {
        log.debug("{}", uid);
        User user = users.stream()
                .filter(u -> u.getId() == uid)
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(user)
                .map(u -> Map.of("user", u))
                .orElse(Map.of());
    }

    @PostMapping("/users")
    public Map postUser(@RequestBody User user) {
        users.add(user);
        return Map.of("users", user);
    }

    private static List<User> users = create();

    private static List<User> create() {
        users = new ArrayList<>();
        User user = new User(1, "BO", "123456", "956");
        User user1 = new User(2, "SUN", "1122", "1021");
        User user2 = new User(3, "ZHANG", "5544", "1221");
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }
}
