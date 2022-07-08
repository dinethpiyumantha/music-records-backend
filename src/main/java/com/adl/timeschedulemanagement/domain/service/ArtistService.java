package com.adl.timeschedulemanagement.domain.service;

import com.adl.timeschedulemanagement.domain.boundary.AlbumRepositoryInterface;
import com.adl.timeschedulemanagement.domain.boundary.ArtistRepositoryInterface;
import com.adl.timeschedulemanagement.domain.entities.Album;
import com.adl.timeschedulemanagement.domain.entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ArtistService {

    @Autowired
    ArtistRepositoryInterface artistRepositoryInterface;
    @Autowired
    AlbumRepositoryInterface albumRepositoryInterface;

    public Artist create(Artist artist) {
        return artistRepositoryInterface.save(artist);
    }

    public List<Artist> createAll(List<Artist> artists) {
        return artistRepositoryInterface.saveAll(artists);
    }

    public Artist getById(int id) {
        return artistRepositoryInterface.findById(id).get();
    }

    public List<Artist> getAll() {
        List<Artist> artists = new ArrayList<Artist>();
        artistRepositoryInterface.findAll().forEach(artist -> artists.add(artist));
        return artists;
    }

    public Artist update(Artist artist) {
        return artistRepositoryInterface.save(artist);
    }

    public Boolean removeById(int id) {
        try {
            artistRepositoryInterface.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Add new element into albums property of Artist object
     * @param artistId - int
     * @param albumId - int
     * @return Artist
     */
    public Artist addAlbumById(int artistId, int albumId) {

        // Get Artist and Album instances by ids
        Artist artist = artistRepositoryInterface.findById(artistId).get();
        Album album = albumRepositoryInterface.findById(albumId).get();

        // Get all already exist albums from artist
        Set<Album> albums = artist.getAlbums();

        // Add new album object into the list
        albums.add(album);

        // Update object
        artist.setAlbums(albums);
        return artistRepositoryInterface.save(artist);
    }

}
