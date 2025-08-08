package com.burock.relations.onetomanytoone.bidirectional.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burock.relations.onetomanytoone.bidirectional.entity.Band;
import com.burock.relations.onetomanytoone.bidirectional.entity.Musician;
import com.burock.relations.onetomanytoone.bidirectional.repository.BandRepository;

@Service
public class BandService {
    
    @Autowired
    private BandRepository bandRepository;

    public Band createBand(Band band) {
        return bandRepository.save(band);
    }

    public List<Band> getAllBands() {
        return bandRepository.findAll();
    }

    public Band getBandById(Long id) {
        return bandRepository.findById(id).orElse(null);
    }

    public Band addMusicianToBand(Long bandId, Musician musician) {
        Optional<Band> bandOpt = bandRepository.findById(bandId);
        if (bandOpt.isPresent()) {
            Band band = bandOpt.get();
            band.addMusician(musician);
            return bandRepository.save(band);
        }
        return null;
    }

    public Band updateBand(Long id, Band bandDetails) {
        Optional<Band> optionalBand = bandRepository.findById(id);  
        if (optionalBand.isPresent()) {
            Band band = optionalBand.get();
            band.setName(bandDetails.getName());
            band.setGenre(bandDetails.getGenre());
            band.setFoundedYear(bandDetails.getFoundedYear());
            return bandRepository.save(band);
        }
        return null;
    }

    public void deleteBand(Long id) {
        bandRepository.deleteById(id);
    }
}
