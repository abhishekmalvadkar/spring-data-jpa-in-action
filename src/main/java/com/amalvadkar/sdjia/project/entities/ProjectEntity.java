package com.amalvadkar.sdjia.project.entities;

import com.amalvadkar.sdjia.project.entities.enums.ProjectStatusEnum;
import com.amalvadkar.sdjia.project.entities.enums.ProjectTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "project")
@ToString
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ProjectStatusEnum projectStatusEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    private ProjectTypeEnum projectTypeEnum;

    @PrePersist
    public void prePersist() {
        this.projectStatusEnum = ProjectStatusEnum.OPEN;
    }
}
