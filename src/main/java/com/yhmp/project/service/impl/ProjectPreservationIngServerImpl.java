package com.yhmp.project.service.impl;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhmp.project.dao.ProjectPreservationIngDao;
import com.yhmp.project.entity.ProjectPreservation;
import com.yhmp.project.service.ProjectPreservationIngServer;

@Service
public class ProjectPreservationIngServerImpl implements ProjectPreservationIngServer {

    @Autowired
    private ProjectPreservationIngDao projectPreservationDao;
    
    @Override
    public Integer saveProjectPreservation(ProjectPreservation projectPreservation) {
        System.out.println("===============================================");
        System.out.println("ProjectPreservationServerImpl.saveProjectPreservation()");
        System.out.println(projectPreservation);
        Integer i = projectPreservationDao.saveProjectPreservation(projectPreservation);
        return i;
    }

    @Override
    public ProjectPreservation selectPreservation(ProjectPreservation projectPreservation) {
        ProjectPreservation newProjectPreservation = projectPreservationDao.selectPreservation(projectPreservation);
        System.out.println("=============================selectPreservation========================");
        System.out.println(newProjectPreservation);
        return newProjectPreservation;
    }

}
