package com.yhmp.project.service;

import com.yhmp.project.entity.ProjectPreservation;

public interface ProjectPreservationIngServer {

    Integer saveProjectPreservation(ProjectPreservation projectPreservation);
    ProjectPreservation selectPreservation(ProjectPreservation projectPreservation);
}
