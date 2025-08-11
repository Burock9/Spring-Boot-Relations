package com.burock.relations.manytomany.unidirectional.service;

import java.util.List;

import org.springframework.stereotype.*;

import com.burock.relations.manytomany.unidirectional.model.Role;
import com.burock.relations.manytomany.unidirectional.model.User;
import com.burock.relations.manytomany.unidirectional.repository.RoleRepository;
import com.burock.relations.manytomany.unidirectional.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User addRoleToUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı."));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Rol bulunamadı."));
        user.getRoles().add(role);
        return userRepository.save(user);
    }
    public User removeRoleFromUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı."));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Rol bulunamadı."));
        user.getRoles().remove(role);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı."));
    } 

    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        user.setUsername(updatedUser.getUsername());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
