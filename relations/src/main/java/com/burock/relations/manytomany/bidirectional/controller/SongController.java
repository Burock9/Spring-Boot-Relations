package com.burock.relations.manytomany.bidirectional.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.burock.relations.manytomany.bidirectional.model.Song;
import com.burock.relations.manytomany.bidirectional.service.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songService.getSongById(id);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }
}
