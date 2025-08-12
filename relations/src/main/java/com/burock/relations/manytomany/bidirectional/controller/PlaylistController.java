package com.burock.relations.manytomany.bidirectional.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.*;

import com.burock.relations.manytomany.bidirectional.model.Playlist;
import com.burock.relations.manytomany.bidirectional.service.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody Playlist updatedPlaylist) {
        return playlistService.updatePlaylist(id, updatedPlaylist);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }

    @PostMapping("/{id}/songs")
    public Playlist updatedPlaylistSongs(@PathVariable Long id, @RequestBody Set<Long> songIds) {
        return playlistService.updatePlaylistSongs(id, songIds);
    }
}