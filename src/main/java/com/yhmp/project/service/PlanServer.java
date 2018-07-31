package com.yhmp.project.service;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import com.yhmp.project.entity.ProjectPlan;
/**
 * 项目计划接口由具体实现类来实现业务
 * @author Liang
 *
 */
public interface PlanServer {

	Integer addPrjectPlan(ProjectPlan projectPlan);
	Integer deletePrjectPlan(ProjectPlan projectPlan);
	List<ProjectPlan> selectPrjectPlan(ProjectPlan projectPlan);
	
	Integer addTruePrjectPlan(ProjectPlan projectPlan);
	Integer deleteTruePrjectPlan(ProjectPlan projectPlan);
	List<ProjectPlan> selectTruePrjectPlan(ProjectPlan projectPlan);
	
}
