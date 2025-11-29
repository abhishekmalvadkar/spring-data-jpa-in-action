package com.amalvadkar.sdjia.project.models.response;

import com.amalvadkar.sdjia.project.entities.enums.ProjectStatusEnum;
import com.amalvadkar.sdjia.project.entities.enums.ProjectTypeEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FetchProjectResponse {

    private Long projectId;
    private String projectName;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private ProjectStatusEnum projectStatus;
    private ProjectTypeEnum projectType;
}
