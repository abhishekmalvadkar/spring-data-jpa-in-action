package com.amalvadkar.sdjia.project.factories;

import com.amalvadkar.sdjia.project.entities.ProjectEntity;
import com.amalvadkar.sdjia.project.entities.enums.ProjectTypeEnum;
import com.amalvadkar.sdjia.project.models.request.ProjectCreateRequest;
import com.amalvadkar.sdjia.project.models.response.FetchProjectResponse;
import com.amalvadkar.sdjia.project.models.response.ProjectCreateResponse;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ProjectFactory {
    public static ProjectEntity entityFrom(ProjectCreateRequest projectCreateRequest) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(projectCreateRequest.getProjectName());
        projectEntity.setStartDate(projectCreateRequest.getProjectStartDate());
        projectEntity.setProjectTypeEnum(projectCreateRequest.getProjectType());
        return projectEntity;
    }

    public static ProjectCreateResponse responseFrom(ProjectEntity projectEntity) {
        return new ProjectCreateResponse(projectEntity.getId());
    }

    public static List<FetchProjectResponse> fromEntities(List<ProjectEntity> entities) {
      return entities.stream()
               .map(ProjectFactory::toResponse)
               .toList();

    }

    private static FetchProjectResponse toResponse(ProjectEntity entity) {
        FetchProjectResponse fetchProjectResponse = new FetchProjectResponse();
        fetchProjectResponse.setProjectId(entity.getId());
        fetchProjectResponse.setProjectName(entity.getName());
        fetchProjectResponse.setProjectEndDate(entity.getEndDate());
        fetchProjectResponse.setProjectStartDate(entity.getStartDate());
        fetchProjectResponse.setProjectType(entity.getProjectTypeEnum());
        fetchProjectResponse.setProjectStatus(entity.getProjectStatusEnum());
        return fetchProjectResponse;
    }

    public static ProjectCreateRequest defaultCreateRequest() {
        ProjectCreateRequest projectCreateRequest = new ProjectCreateRequest();
        projectCreateRequest.setProjectName("Healthcare");
        projectCreateRequest.setProjectType(ProjectTypeEnum.DEDICATED);
        projectCreateRequest.setProjectStartDate(LocalDate.of(2025, Month.JANUARY, 1));
        return projectCreateRequest;
    }

    public static List<ProjectEntity> defaultProjectList(){
        ProjectEntity healthCareProjectEntity = new ProjectEntity();
        healthCareProjectEntity.setName("Hospitality");
        healthCareProjectEntity.setStartDate(LocalDate.of(2025, Month.JANUARY, 1));
        healthCareProjectEntity.setProjectTypeEnum(ProjectTypeEnum.DEDICATED);

        ProjectEntity hrProjectEntity = new ProjectEntity();
        hrProjectEntity.setName("HR");
        hrProjectEntity.setStartDate(LocalDate.of(2024, Month.JANUARY, 12));
        hrProjectEntity.setProjectTypeEnum(ProjectTypeEnum.IN_HOUSE);
        return List.of(healthCareProjectEntity,hrProjectEntity);
    }


}
