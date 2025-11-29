package com.amalvadkar.sdjia.project.controllers;

import com.amalvadkar.sdjia.project.models.request.ProjectCreateRequest;
import com.amalvadkar.sdjia.project.models.response.ProjectCreateResponse;
import com.amalvadkar.sdjia.project.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pms/project")
@RequiredArgsConstructor
public class ProjectRestController {

    private final ProjectService projectService;

    @PostMapping("/create-project")
    public ResponseEntity<ProjectCreateResponse> createProject(@RequestBody ProjectCreateRequest projectCreateRequest){
        ProjectCreateResponse projectCreateResponse = projectService.createProject(projectCreateRequest);
        return ResponseEntity.ok(projectCreateResponse);
    }

}
