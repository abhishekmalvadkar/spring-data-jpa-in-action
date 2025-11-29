package com.amalvadkar.sdjia.project.models.request;

import com.amalvadkar.sdjia.project.entities.enums.ProjectTypeEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectCreateRequest {
    private String projectName;
    private ProjectTypeEnum projectType;
    private LocalDate projectStartDate;
}
