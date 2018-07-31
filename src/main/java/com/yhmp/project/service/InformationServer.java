package com.yhmp.project.service;

import java.util.List;

import com.yhmp.project.entity.PorjectDeclare;
import com.yhmp.project.entity.ProjectPlan;
/**
 * 项目信息接口由具体实现类来实现业务
 * @author Administrator
 *
 */
public interface InformationServer {

	<T> T selectProjectInformation(PorjectDeclare porjectDeclare);
	Integer editProject(PorjectDeclare porjectDeclare);
	Integer deleteProject(PorjectDeclare porjectDeclare);
	Integer updateAllplanSchedule(PorjectDeclare porjectDeclare);
	//查询单个已完成项目
    PorjectDeclare selectOneProjectInfo(PorjectDeclare porjectDeclare);
}
