package com.amalvadkar.sdjia.project.repos.services;

import com.amalvadkar.sdjia.project.entities.ProjectEntity;
import com.amalvadkar.sdjia.project.entities.enums.ProjectStatusEnum;
import com.amalvadkar.sdjia.project.factories.ProjectFactory;
import com.amalvadkar.sdjia.project.models.request.ProjectCreateRequest;
import com.amalvadkar.sdjia.project.models.response.ProjectCreateResponse;
import com.amalvadkar.sdjia.project.repos.ProjectRepo;
import com.amalvadkar.sdjia.project.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepo projectRepo;

    @BeforeEach
    void setUp() {
        projectRepo.deleteAll();
        List<ProjectEntity> projects = ProjectFactory.defaultProjectList();
        projectRepo.saveAll(projects);
    }

    @Test
    void should_create_new_project() {
        ProjectCreateRequest projectCreateRequest = ProjectFactory.defaultCreateRequest();
        ProjectCreateResponse newCreatedProjectResponse = projectService.createProject(projectCreateRequest);
        assertThat(newCreatedProjectResponse.projectId()).isNotNull();

        Optional<ProjectEntity> projectEntityOpt = projectRepo.findById(newCreatedProjectResponse.projectId());
        assertThat(projectEntityOpt).isNotEmpty();

        ProjectEntity projectEntity = projectEntityOpt.get();
        assertThat(projectEntity.getName()).isEqualTo(projectCreateRequest.getProjectName());
        assertThat(projectEntity.getProjectTypeEnum()).isEqualTo(projectCreateRequest.getProjectType());
        assertThat(projectEntity.getStartDate()).isEqualTo(projectCreateRequest.getProjectStartDate());
        assertThat(projectEntity.getProjectStatusEnum()).isEqualTo(ProjectStatusEnum.OPEN);
        assertThat(projectEntity.getEndDate()).isNull();
    }

    @Test
    void should_fetch_projects() {
        assertThat(projectService.fetchProject()).hasSize(2);
    }

    @Test
    void should_fetch_project_projectName() {
        assertThat(projectService.fetchProject("Hospitality")).isNotNull();
    }

}