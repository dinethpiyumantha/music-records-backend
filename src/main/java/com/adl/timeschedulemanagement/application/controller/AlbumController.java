package com.adl.timeschedulemanagement.application.controller;

import com.adl.timeschedulemanagement.domain.entities.Album;
import com.adl.timeschedulemanagement.domain.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping
    private List<Album> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    private Album getById(@PathVariable("id") int id) {
        return albumService.getById(id);
    }

    @PostMapping
    private Album create(@RequestBody Album album) {
        return albumService.create(album);
    }

    @PostMapping("/list")
    private List<Album> createAll(@RequestBody List<Album> albums) {
        return albumService.createAll(albums);
    }

    @PostMapping("/{albumId}/genre/{genreId}")
    private Album assignGenreById(
            @PathVariable("albumId") int albumId,
            @PathVariable("genreId") int genreId
    ) {
        return albumService.assignGenreById(albumId, genreId);
    }

    @PostMapping("/{albumId}/label/{labelId}")
    private Album assignLabelById(
            @PathVariable("albumId") int albumId,
            @PathVariable("labelId") int labelId
    ) {
        return albumService.assignLabelById(albumId, labelId);
    }

    @PutMapping
    private Album update(@RequestBody Album album) {
        return albumService.update(album);
    }

    @DeleteMapping("/{id}")
    private Boolean removeById(@PathVariable("id") int id) {
        return albumService.removeById(id);
    }
}
