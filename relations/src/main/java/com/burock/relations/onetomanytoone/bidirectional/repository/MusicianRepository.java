package com.burock.relations.onetomanytoone.bidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burock.relations.onetomanytoone.bidirectional.entity.Musician;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

}
