package com.burock.relations.onetomanytoone.unidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burock.relations.onetomanytoone.unidirectional.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
