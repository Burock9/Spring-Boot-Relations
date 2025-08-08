package com.burock.relations.onetomanytoone.bidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burock.relations.onetomanytoone.bidirectional.entity.Band;

public interface BandRepository extends JpaRepository<Band, Long> {

}
