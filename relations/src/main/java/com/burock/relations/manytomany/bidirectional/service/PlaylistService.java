package com.burock.relations.manytomany.bidirectional.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.*;

import com.burock.relations.manytomany.bidirectional.model.Playlist;
import com.burock.relations.manytomany.bidirectional.model.Song;
import com.burock.relations.manytomany.bidirectional.repository.PlaylistRepository;
import com.burock.relations.manytomany.bidirectional.repository.SongRepository;

import jakarta.transaction.Transactional;

@Service
public class PlaylistService {

    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(Long id) {
        return playlistRepository.findById(id).orElseThrow(() -> new RuntimeException("Playlist Bulunamadı."));
    }

    public Playlist updatePlaylist(Long id, Playlist updatedPlaylist) {
        Playlist playlist = getPlaylistById(id);
        playlist.setName(updatedPlaylist.getName());
        return playlistRepository.save(playlist);
    }

    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

    @Transactional
    public Playlist updatePlaylistSongs(Long playlistId, Set<Long> songIds) {
        Playlist playlist = getPlaylistById(playlistId);
        Set<Song> songs = songRepository.findAllById(songIds).stream().collect(Collectors.toSet());
        if (songs.size() != songIds.size()) {
            throw new RuntimeException("Bazı şarkılar bulunamadı.");
        }
        playlist.setSongs(songs);
        return playlistRepository.save(playlist);
    }
}
