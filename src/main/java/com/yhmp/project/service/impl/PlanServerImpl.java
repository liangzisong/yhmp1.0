package com.yhmp.project.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhmp.project.dao.PlanDao;
import com.yhmp.project.entity.ProjectPlan;
import com.yhmp.project.service.PlanServer;
/**
 * 项目计划server
 * @author liang
 *
 */
@Service
public class PlanServerImpl implements PlanServer {

	@Autowired
	private PlanDao planDao;
	/**
	 * 添加计划进度
	 */
	@Override
	public Integer addPrjectPlan(ProjectPlan projectPlan) {
	    System.out.println("PlanServerImpl.addPrjectPlan()");
	    System.out.println(projectPlan);
		List<ProjectPlan> list = new ArrayList<ProjectPlan>();
		
		//分计划|
		String[] projects = projectPlan.getPeriodicPlan().split("\\|");
		System.out.println("============s==========");
		System.out.println(Arrays.toString(projects));
		
		for(int i=0;i<projects.length;i++) {
			ProjectPlan newProjectPlan = new ProjectPlan();
			System.out.println("projects[i]="+projects[i]);
			//获取各计划的值
			String[] plan = projects[i].split("\\^");
			/*if(String.valueOf(i+1).equals(plan[plan.length - 1])) {
			    ArrayList<String> list1=new ArrayList<String>();
			    list1.toArray(plan);
			    list.remove(list.size()-1);
			    list.toArray(plan);
			}*/
		    /*for(int j=0;j<plan.length;j++){
		        System.out.println(plan[j]);
		        System.out.println("".equals(plan[j]));
		        //用户输入非空判断
		        if("".equals(plan[j]) || plan[j] == null){
		            System.out.println();
		            //第二个是阶段进度
		            if(j==2) {
		                plan[j] = "0";
		            }
		              //第三个是时间
	                if(j==3) {
	                    //设置默认时间，当前时间
	                    plan[j] = String.valueOf(LocalDate.now());
	                    continue;
	                }
		            plan[j] = "未填写";
		        }
		    }*/
			System.out.println("========p==========");
			System.out.println("plan.length="+plan.length);
			System.out.println(Arrays.toString(plan));
			//id
			newProjectPlan.setFk_project_id(projectPlan.getFk_project_id());
			
			newProjectPlan.setDeclareProject(projectPlan.getDeclareProject());
			newProjectPlan.setResponsibilityName(projectPlan.getResponsibilityName());
			newProjectPlan.setProjectPlan(Integer.valueOf(plan[0]));
			newProjectPlan.setPlanSchedule(Integer.valueOf(plan[1]));
			newProjectPlan.setProjectContent(plan[2]);
			newProjectPlan.setFinishTime(plan[3]);
			newProjectPlan.setPersonLiable(plan[4]);
			list.add(newProjectPlan);
		}
		System.out.println("list.stream().forEach(p -> System.out.println(p));");
		list.stream().forEach(p -> System.out.println(p));
		System.out.println("for(ProjectPlan pp :list) {");
		for(ProjectPlan pp :list) {
			System.out.println(pp);
		}
		Integer i = planDao.addPrjectPlan(list);
		return i;
	}

	@Override
	public List<ProjectPlan> selectPrjectPlan(ProjectPlan porjectPlan) {
		List<ProjectPlan> list = planDao.selectPrjectPlan(porjectPlan);
		System.out.println("===========================");
		list.forEach(i ->System.out.println(i));
		return list;
	}
/**
 * 删除计划进度
 */
	@Override
	public Integer deletePrjectPlan(ProjectPlan projectPlan) {
		Integer i =planDao.deletePrjectPlan(projectPlan);
		return i;
	}

	/**
	 * 添加实际进度
	 */
	@Override
	public Integer addTruePrjectPlan(ProjectPlan projectPlan) {
		List<ProjectPlan> list = new ArrayList<ProjectPlan>();
		
		//分计划|
		String[] projects = projectPlan.getPeriodicPlan().split("\\|");
		System.out.println("============s==========");
		System.out.println(Arrays.toString(projects));
		
		for(int i=0;i<projects.length;i++) {
			ProjectPlan newProjectPlan = new ProjectPlan();
			System.out.println("projects[i]="+projects[i]);
			//获取各计划的值
			String[] plan = projects[i].split("\\^");
			System.out.println("========p==========");
			System.out.println("plan.length="+plan.length);
			System.out.println(Arrays.toString(plan));
			//id
			newProjectPlan.setFk_project_id(projectPlan.getFk_project_id());
			
			newProjectPlan.setProjectPlan(Integer.valueOf(plan[0]));
			newProjectPlan.setPlanSchedule(Integer.valueOf(plan[1]));
			newProjectPlan.setProjectContent(plan[2]);
			newProjectPlan.setFinishTime(plan[3]);
			newProjectPlan.setTimeAdjustment(plan[4]);
			list.add(newProjectPlan);
		}
		System.out.println("list.stream().forEach(p -> System.out.println(p));");
		list.stream().forEach(p -> System.out.println(p));
		System.out.println("for(ProjectPlan pp :list) {");
		for(ProjectPlan pp :list) {
			System.out.println(pp);
		}
		Integer i = planDao.addTruePrjectPlan(list);
		return i;
	}

	/**
	 * 删除实际进度
	 */
	@Override
	public Integer deleteTruePrjectPlan(ProjectPlan projectPlan) {
		Integer i =planDao.deleteTruePrjectPlan(projectPlan);
		return i;
	}

	@Override
	public List<ProjectPlan> selectTruePrjectPlan(ProjectPlan projectPlan) {
		List<ProjectPlan> list = planDao.selectTruePrjectPlan(projectPlan);
		System.out.println("===========================");
		list.forEach(i ->System.out.println(i));
		return list;
	}

}
