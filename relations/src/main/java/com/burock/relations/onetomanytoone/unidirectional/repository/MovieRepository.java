package com.burock.relations.onetomanytoone.unidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burock.relations.onetomanytoone.unidirectional.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
