package com.burock.relations.manytomany.unidirectional.service;

import java.util.List;

import org.springframework.stereotype.*;

import com.burock.relations.manytomany.unidirectional.model.Role;
import com.burock.relations.manytomany.unidirectional.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol bulunamadı."));
    }

    public Role updateRole(Long id, Role updatedRole) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol bulunamadı."));
        role.setName(updatedRole.getName());
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
