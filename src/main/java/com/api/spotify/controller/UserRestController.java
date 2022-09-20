package com.api.spotify.controller;

import com.api.spotify.entity.User;
import com.api.spotify.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getList() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @PutMapping("/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.update(newUser, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

}
