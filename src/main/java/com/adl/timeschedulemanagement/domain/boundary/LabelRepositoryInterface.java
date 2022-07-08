package com.adl.timeschedulemanagement.domain.boundary;

import com.adl.timeschedulemanagement.domain.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepositoryInterface extends JpaRepository<Label, Integer> {
}
