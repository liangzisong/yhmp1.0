package com.yhmp.project.dao;

import com.yhmp.project.entity.ProjectSummary;

public interface ProjectSummaryDao {
    Integer addProjectSummary(ProjectSummary projectSummary);
    Integer updateProjectSummary(ProjectSummary projectSummary);
    ProjectSummary selectProjectSummary(ProjectSummary projectSummary);
}
