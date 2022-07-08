package com.adl.timeschedulemanagement.application.controller;

import com.adl.timeschedulemanagement.domain.entities.Artist;
import com.adl.timeschedulemanagement.domain.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping
    private List<Artist> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    private Artist getById(@PathVariable("id") int id) {
        return artistService.getById(id);
    }

    @PostMapping
    private Artist create(@RequestBody Artist artist) {
        return artistService.create(artist);
    }

    @PostMapping("/list")
    private List<Artist> createAll(@RequestBody List<Artist> artists) {
        return artistService.createAll(artists);
    }

    @PostMapping("/{artistId}/album/{albumId}")
    private Artist addAlbum(
            @PathVariable("artistId") int artistId,
            @PathVariable("albumId") int albumId
    ) {
        return artistService.addAlbumById(artistId, albumId);
    }

    @PutMapping
    private Artist update(@RequestBody Artist artist) {
        return artistService.update(artist);
    }

    @DeleteMapping("/{id}")
    private Boolean removeById(@PathVariable("id") int id) {
        return artistService.removeById(id);
    }

}
