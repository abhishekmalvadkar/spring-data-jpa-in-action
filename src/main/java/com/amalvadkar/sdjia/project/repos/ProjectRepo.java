package com.amalvadkar.sdjia.project.repos;

import com.amalvadkar.sdjia.project.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<ProjectEntity, Long> {
}