package com.amalvadkar.sdjia.project.repos;

import com.amalvadkar.sdjia.project.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<ProjectEntity, Long> {

     Optional<ProjectEntity> findByName(String projectName);

    default ProjectEntity findByNameOrThrow(String projectName) {
        return findByName(projectName).
                orElseThrow(() -> new RuntimeException("project not found"));
    }
}