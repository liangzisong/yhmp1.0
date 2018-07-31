package com.yhmp.project.dao;

import java.util.List;

import com.yhmp.project.entity.PorjectDeclare;
import com.yhmp.project.entity.ProjectPlan;
/**
 * 项目信息dao对应mapper
 * @author liang
 *
 */
public interface InformationDao {

	List<PorjectDeclare> selectProjectInformation(PorjectDeclare porjectDeclare);
	Integer editProject(PorjectDeclare porjectDeclare);
	Integer deleteProject(PorjectDeclare porjectDeclare);
	Integer updateAllplanSchedule(PorjectDeclare porjectDeclare);
	//查询单个已完成项目
	PorjectDeclare selectOneProjectInfo(PorjectDeclare porjectDeclare);
}