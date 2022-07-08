package com.adl.timeschedulemanagement.domain.boundary;

import com.adl.timeschedulemanagement.domain.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepositoryInterface extends JpaRepository<Genre, Integer> {
}
