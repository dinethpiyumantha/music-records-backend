package com.adl.timeschedulemanagement.domain.boundary;

import com.adl.timeschedulemanagement.domain.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepositoryInterface extends JpaRepository<Album, Integer> {
}
