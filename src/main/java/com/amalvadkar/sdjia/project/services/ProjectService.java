package com.amalvadkar.sdjia.project.services;

import com.amalvadkar.sdjia.project.entities.ProjectEntity;
import com.amalvadkar.sdjia.project.factories.ProjectFactory;
import com.amalvadkar.sdjia.project.models.request.ProjectCreateRequest;
import com.amalvadkar.sdjia.project.models.response.FetchProjectResponse;
import com.amalvadkar.sdjia.project.models.response.ProjectCreateResponse;
import com.amalvadkar.sdjia.project.repos.ProjectRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final SpringDebugger springDebugger;

    @Transactional
    public ProjectCreateResponse createProject(ProjectCreateRequest projectCreateRequest) {
        ProjectEntity projectEntity = ProjectFactory.entityFrom(projectCreateRequest);
        ProjectEntity savedProjectEntity = projectRepo.save(projectEntity);
        return ProjectFactory.responseFrom(savedProjectEntity);
    }

    public List<FetchProjectResponse> fetchProjects() {
        List<ProjectEntity> allProjects = projectRepo.findAll();
        log.info("total projects :{}", allProjects.size());
        return ProjectFactory.fromEntities(allProjects);
    }

}
