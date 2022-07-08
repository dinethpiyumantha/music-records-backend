package com.adl.timeschedulemanagement.domain.service;

import com.adl.timeschedulemanagement.domain.boundary.AlbumRepositoryInterface;
import com.adl.timeschedulemanagement.domain.boundary.GenreRepositoryInterface;
import com.adl.timeschedulemanagement.domain.boundary.LabelRepositoryInterface;
import com.adl.timeschedulemanagement.domain.entities.Album;
import com.adl.timeschedulemanagement.domain.entities.Genre;
import com.adl.timeschedulemanagement.domain.entities.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepositoryInterface albumRepositoryInterface;
    @Autowired
    LabelRepositoryInterface labelRepositoryInterface;
    @Autowired
    GenreRepositoryInterface genreRepositoryInterface;

    public Album create(Album album) {
        return albumRepositoryInterface.save(album);
    }

    public List<Album> createAll(List<Album> albums) {
        return albumRepositoryInterface.saveAll(albums);
    }

    public Album getById(int id) {
        return albumRepositoryInterface.findById(id).get();
    }

    public List<Album> getAll() {
        List<Album> albums = new ArrayList<Album>();
        albumRepositoryInterface.findAll().forEach(album -> albums.add(album));
        return albums;
    }

    public Album update(Album album) {
        return albumRepositoryInterface.save(album);
    }

    public Boolean removeById(int id) {
        try {
            albumRepositoryInterface.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Update Label object of Album object
     * @param albumId - int
     * @param labelId - int
     * @return Album
     */
    public Album assignLabelById(int albumId, int labelId) {

        // Get Artist and Album instances by ids
        Album album = albumRepositoryInterface.findById(albumId).get();
        Label label = labelRepositoryInterface.findById(labelId).get();

        // Update album
        album.setLabel(label);
        return albumRepositoryInterface.save(album);
    }

    /**
     * Update Genre object of Album object
     * @param albumId - int
     * @param genreId - int
     * @return Album
     */
    public Album assignGenreById(int albumId, int genreId) {

        // Get Artist and Genre instances by ids
        Album album = albumRepositoryInterface.findById(albumId).get();
        Genre genre = genreRepositoryInterface.findById(genreId).get();

        // Update album
        album.setGenre(genre);
        return albumRepositoryInterface.save(album);
    }

}
