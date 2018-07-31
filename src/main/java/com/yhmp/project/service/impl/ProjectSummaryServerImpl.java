package com.yhmp.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhmp.common.exception.ServiceException;
import com.yhmp.project.dao.ProjectSummaryDao;
import com.yhmp.project.entity.ProjectSummary;
import com.yhmp.project.service.ProjectSummaryServer;
@Service
public class ProjectSummaryServerImpl implements ProjectSummaryServer {

    @Autowired
    private ProjectSummaryDao projectSummaryDao;
    @Override
    public Integer addProjectSummary(ProjectSummary projectSummary) {
        Integer i = projectSummaryDao.addProjectSummary(projectSummary);
            return i;
    }

    @Override
    public Integer updateProjectSummary(ProjectSummary projectSummary) {
        Integer i = projectSummaryDao.updateProjectSummary(projectSummary);
            return i;
        
        //return "修改失败";
    }

    @Override
    public ProjectSummary selectProjectSummary(ProjectSummary projectSummary) {
        ProjectSummary newProjectSummary = projectSummaryDao.selectProjectSummary(projectSummary);
        System.out.println(newProjectSummary);
        return newProjectSummary;
    }

}
