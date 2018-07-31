package com.yhmp.project.service;

import com.yhmp.project.entity.ProjectSummary;

public interface ProjectSummaryServer {

    Integer addProjectSummary(ProjectSummary projectSummary);
    Integer updateProjectSummary(ProjectSummary projectSummary);
    ProjectSummary selectProjectSummary(ProjectSummary projectSummary);
}
