package com.burock.relations.onetomanytoone.bidirectional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.burock.relations.onetomanytoone.bidirectional.entity.Band;
import com.burock.relations.onetomanytoone.bidirectional.entity.Musician;
import com.burock.relations.onetomanytoone.bidirectional.service.BandService;

@RestController
@RequestMapping("/api/bands")
public class BandController {

    @Autowired
    private BandService bandService;

    @PostMapping
    public Band createBand(Band band) {
        return bandService.createBand(band);
    }

    @GetMapping
    public List<Band> getAllBands() {
        return bandService.getAllBands();
    }

    @GetMapping("/{id}")
    public Band getBandById(Long id) {
        return bandService.getBandById(id);
    }

    @PostMapping("/{bandId}/musicians")
    public Band addMusicianToBand(@PathVariable Long bandId, @RequestBody Musician musician) {
        return bandService.addMusicianToBand(bandId, musician);
    }

    @PutMapping("/{id}")
    public Band updateBand(@PathVariable Long id, @RequestBody Band updatedBand) {
        return bandService.updateBand(id, updatedBand);
    }

    @DeleteMapping("/{id}")
    public void deleteBand(@PathVariable Long id) {
        bandService.deleteBand(id);
    }
    
}
