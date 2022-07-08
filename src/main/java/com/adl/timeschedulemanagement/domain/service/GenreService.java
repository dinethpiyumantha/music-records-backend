package com.adl.timeschedulemanagement.domain.service;

import com.adl.timeschedulemanagement.domain.boundary.GenreRepositoryInterface;
import com.adl.timeschedulemanagement.domain.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepositoryInterface genreRepositoryInterface;

    public Genre create(Genre genre) {
        return genreRepositoryInterface.save(genre);
    }

    public List<Genre> createAll(List<Genre> genres) {
        return genreRepositoryInterface.saveAll(genres);
    }

    public Genre getById(int id) {
        return genreRepositoryInterface.findById(id).get();
    }

    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<Genre>();
        genreRepositoryInterface.findAll().forEach(genre -> genres.add(genre));
        return genres;
    }

    public Genre update(Genre genre) {
        return genreRepositoryInterface.save(genre);
    }

    public Boolean removeById(int id) {
        try {
            genreRepositoryInterface.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
