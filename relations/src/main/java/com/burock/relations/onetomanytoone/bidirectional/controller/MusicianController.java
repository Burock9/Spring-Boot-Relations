package com.burock.relations.onetomanytoone.bidirectional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.burock.relations.onetomanytoone.bidirectional.entity.Musician;
import com.burock.relations.onetomanytoone.bidirectional.service.MusicianService;

@RestController
@RequestMapping("/api/musicians")
public class MusicianController {

    @Autowired
    private MusicianService musicianService;

    @PostMapping
    public Musician createMusician(@RequestBody Musician musician) {
        return musicianService.createMusician(musician);
    }

    @GetMapping
    public List<Musician> getAllMusicians() {
        return musicianService.getAllMusicians();
    }

    @GetMapping("/{id}")
    public Musician getMusicianById(@PathVariable Long id) {
        return musicianService.getMusicianById(id);
    }

    @PutMapping("/{id}")
    public Musician updateMusician(@PathVariable Long id, @RequestBody Musician updatedMusician) {
        return musicianService.updateMusician(id, updatedMusician);
    }

    @DeleteMapping("/{id}")
    public void deleteMusician(@PathVariable Long id) {
        musicianService.deleteMusician(id);
    }
}
