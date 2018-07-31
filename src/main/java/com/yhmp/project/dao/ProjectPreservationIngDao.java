package com.yhmp.project.dao;

import com.yhmp.project.entity.ProjectPreservation;

public interface ProjectPreservationIngDao {

    Integer saveProjectPreservation(ProjectPreservation projectPreservation);
    ProjectPreservation selectPreservation(ProjectPreservation projectPreservation);
}
