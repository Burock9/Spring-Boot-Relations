package com.burock.relations.manytomany.bidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.burock.relations.manytomany.bidirectional.model.Song;

public interface SongRepository extends JpaRepository<Song, Long>{

}
