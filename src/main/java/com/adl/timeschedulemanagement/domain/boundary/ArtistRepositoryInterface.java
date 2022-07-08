package com.adl.timeschedulemanagement.domain.boundary;

import com.adl.timeschedulemanagement.domain.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepositoryInterface extends JpaRepository<Artist, Integer> {
}
