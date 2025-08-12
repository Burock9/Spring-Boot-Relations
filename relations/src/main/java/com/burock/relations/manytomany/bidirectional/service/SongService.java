package com.burock.relations.manytomany.bidirectional.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.burock.relations.manytomany.bidirectional.model.Song;
import com.burock.relations.manytomany.bidirectional.repository.SongRepository;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new RuntimeException("Şarkı bulunamadı."));
    }

    public Song updateSong(Long id, Song updatedSong) {
        Song song = getSongById(id);
        song.setTitle(updatedSong.getTitle());
        return songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
