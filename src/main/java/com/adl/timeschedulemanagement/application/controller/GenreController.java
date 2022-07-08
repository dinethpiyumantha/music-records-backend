package com.adl.timeschedulemanagement.application.controller;

import com.adl.timeschedulemanagement.domain.entities.Genre;
import com.adl.timeschedulemanagement.domain.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping
    private List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    private Genre getById(@PathVariable("id") int id) {
        return genreService.getById(id);
    }

    @PostMapping
    private Genre create(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @PostMapping("/list")
    private List<Genre> createAll(@RequestBody List<Genre> genres) {
        return genreService.createAll(genres);
    }

    @PutMapping
    private Genre update(@RequestBody Genre genre) {
        return genreService.update(genre);
    }

    @DeleteMapping("/{id}")
    private Boolean removeById(@PathVariable("id") int id) {
        return genreService.removeById(id);
    }
}
