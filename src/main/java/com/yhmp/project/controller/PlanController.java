package com.yhmp.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.exception.ServiceException;
import com.yhmp.common.web.JsonResult;
import com.yhmp.project.entity.ProjectPlan;
import com.yhmp.project.service.PlanServer;
/**
 * 项目计划控制器
 * @author liang
 *
 */
@Controller
@RequestMapping("/plan/")
@Transactional(rollbackFor=Exception.class)
public class PlanController {

	@Autowired
	public PlanServer planServer;
	@ResponseBody
	@RequestMapping("addPrjectPlan")
	public JsonResult addPrjectPlan(ProjectPlan projectPlan) {
		System.out.println("PlanController.addPrjectPlan()");
		System.out.println("========================================");
		System.out.println(projectPlan);
		Integer i = planServer.addPrjectPlan(projectPlan);
        if(i == 1) {
            return new JsonResult();
        }
        throw new ServiceException("计划进度添加失败");
	}
	@SuppressWarnings("unchecked")
    @ResponseBody
	@RequestMapping("deletePrjectPlan")
	public JsonResult deletePrjectPlan(ProjectPlan projectPlan) {
	    //获取第一个，若没有值说明是第一个直接返回，不抛异常
	    if((List<ProjectPlan>)selectPrjectPlan(projectPlan).getData() == null) {
	        return new JsonResult();
	    }
		System.out.println("PlanController.deletePrjectPlan()");
		System.out.println(projectPlan);
		Integer i = planServer.deletePrjectPlan(projectPlan);
        System.out.println("=================================================删除计划进度i======================================");
        System.out.println(i);
        if(i != 0) {
            return new JsonResult();
        }
        throw new ServiceException("计划进度删除失败");
	}
	@ResponseBody
	@RequestMapping("selectPrjectPlan")
	public JsonResult selectPrjectPlan(ProjectPlan projectPlan) {
		System.out.println("PlanController.addPrjectPlan()");
		System.out.println(projectPlan);
		List<ProjectPlan> list = planServer.selectPrjectPlan(projectPlan);
		return new JsonResult(list);
	}
	/**
	 * 实际进度
	 * @param projectPlan
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping("addTruePrjectPlan")
	public JsonResult addTruePrjectPlan(ProjectPlan projectPlan) {
		System.out.println("================================================添加实际计划===========================================");
		System.out.println("PlanController.addTruePrjectPlan()");
		System.out.println(projectPlan);
		Integer i = planServer.addTruePrjectPlan(projectPlan);
        if(i == 1) {
            return new JsonResult();
        }
        throw new ServiceException("实际进度添加失败");
	}
	@SuppressWarnings("unchecked")
    @ResponseBody
	@RequestMapping("deleteTruePrjectPlan")
	public JsonResult deleteTruePrjectPlan(ProjectPlan projectPlan) {
	    System.out.println("=====================================deleteTruePrjectPlan=============================================");
	    System.out.println((List<ProjectPlan>)selectPrjectPlan(projectPlan).getData() == null);
	  //获取第一个，若没有值说明是第一个直接返回，不抛异常
	    if(((List<ProjectPlan>)selectTruePrjectPlan(projectPlan).getData()) == null) {
	        return  new JsonResult();
	    }
		System.out.println("=====删除实际计划=====");
		System.out.println("PlanController.deletePrjectPlan()");
		System.out.println(projectPlan);
		Integer i = planServer.deleteTruePrjectPlan(projectPlan);
		System.out.println("=================================================删除实际计划i======================================");
		System.out.println(i);
        if(i != 0) {
            return new JsonResult();
        }
        throw new ServiceException("实际进度删除失败");
	}
	@ResponseBody
	@RequestMapping("selectTruePrjectPlan")
	public JsonResult selectTruePrjectPlan(ProjectPlan projectPlan) {
		System.out.println("PlanController.addPrjectPlan()");
		System.out.println(projectPlan);
		List<ProjectPlan> list = planServer.selectTruePrjectPlan(projectPlan);
		return new JsonResult(list);
	}
	
    @ResponseBody
    @RequestMapping("selectOneProjectPlan")
    public JsonResult selectOneProjectPlan(ProjectPlan projectPlan) {
        System.out.println();
        System.out.println(projectPlan);
        List<ProjectPlan> list = planServer.selectTruePrjectPlan(projectPlan);
        return new JsonResult(list);
    }
	
}
