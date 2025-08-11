package com.burock.relations.manytomany.unidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.burock.relations.manytomany.unidirectional.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
