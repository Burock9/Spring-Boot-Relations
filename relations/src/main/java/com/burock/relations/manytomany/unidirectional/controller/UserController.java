package com.burock.relations.manytomany.unidirectional.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.burock.relations.manytomany.unidirectional.model.User;
import com.burock.relations.manytomany.unidirectional.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}") 
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }   

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{userId}/roles/{roleId}")
    public User addRolToUser(@PathVariable Long userId, @PathVariable Long roleId) {
        return userService.addRoleToUser(userId, roleId);
    }

    @DeleteMapping("/{userId}/roles/{roleId}")
    public User removeRoleFromUser(@PathVariable Long userId, @PathVariable Long roleId) {
        return userService.removeRoleFromUser(userId, roleId);
    }
}
