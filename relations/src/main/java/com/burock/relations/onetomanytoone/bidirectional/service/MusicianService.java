package com.burock.relations.onetomanytoone.bidirectional.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burock.relations.onetomanytoone.bidirectional.entity.Musician;
import com.burock.relations.onetomanytoone.bidirectional.repository.MusicianRepository;

@Service
public class MusicianService {

    @Autowired
    private MusicianRepository musicianRepository;

    public Musician createMusician(Musician musician) {
        return musicianRepository.save(musician);
    }

    public List<Musician> getAllMusicians() {
        return musicianRepository.findAll();
    }
    
    public Musician getMusicianById(Long id) {
        return musicianRepository.findById(id).orElse(null);
    }

    public Musician updateMusician(Long id, Musician updatedMusician) {
        Optional<Musician> optionalMusician = musicianRepository.findById(id);
        if (optionalMusician.isPresent()) {
            Musician musician = optionalMusician.get();
            musician.setName(updatedMusician.getName());
            musician.setInstrument(updatedMusician.getInstrument());
            musician.setJoinYear(updatedMusician.getJoinYear());
            return musicianRepository.save(musician);
        }
        return null;
    }

    public void deleteMusician(Long id) {
        musicianRepository.deleteById(id);
    }
}
