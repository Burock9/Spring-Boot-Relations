package com.burock.relations.manytomany.unidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.burock.relations.manytomany.unidirectional.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
