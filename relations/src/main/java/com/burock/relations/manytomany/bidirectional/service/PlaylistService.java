package com.burock.relations.manytomany.bidirectional.service;

import org.springframework.stereotype.*;

import com.burock.relations.manytomany.bidirectional.model.Playlist;
import com.burock.relations.manytomany.bidirectional.repository.PlaylistRepository;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
