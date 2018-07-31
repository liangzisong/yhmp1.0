package com.yhmp.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.exception.ServiceException;
import com.yhmp.common.web.JsonResult;
import com.yhmp.project.entity.PorjectDeclare;
import com.yhmp.project.service.InformationServer;
/**
 * 项目信息控制器
 * @author liang
 *
 */
@Controller
@RequestMapping("/information/")
@Transactional(rollbackFor=Exception.class)
public class InformationController {

	@Autowired
	private InformationServer informationServer;
	
	
	@RequestMapping("listUI")
	public String listUI(@RequestParam(value="user_id") String userId,@RequestParam(value="user_name") String username) {
		System.out.println("进入项目信息");
		return "project/Information";
	}
	@ResponseBody
	@RequestMapping("selectInformation")
	public JsonResult selectInformation(PorjectDeclare porjectDeclare) {
		System.out.println("InformationController.selectInformation()===="+porjectDeclare);
		//单个项目详细信息
		if(informationServer.selectProjectInformation(porjectDeclare) instanceof PorjectDeclare) {
			System.out.println("查询出单个项目");
			PorjectDeclare pd = informationServer.selectProjectInformation(porjectDeclare);
			List<PorjectDeclare> list = new ArrayList<PorjectDeclare>();
			list.add(pd);
			System.out.println("pd="+pd);
			return new JsonResult(list);
		}
		//多个项目
		List<PorjectDeclare> list = informationServer.selectProjectInformation(porjectDeclare);
		System.out.println("======console.porject======");
		for(PorjectDeclare p : list) {
		    System.out.println(p);
		}
		System.out.println("查询出多个项目");
		return new JsonResult(list);
	}
	
	@ResponseBody
	@RequestMapping("editProject")
	public JsonResult editProject(PorjectDeclare porjectDeclare) {
		System.out.println("StffManageController.addPorject()==========================================");
		System.out.println("Porject="+porjectDeclare);
		Integer i = informationServer.editProject(porjectDeclare);
		if(i == 1) {
		    return new JsonResult();
		}
		throw new ServiceException("修改失败");
	}
	@ResponseBody
	@RequestMapping("deleteProject")
	public JsonResult deleteProject(PorjectDeclare porjectDeclare) {
		System.out.println("Porject="+porjectDeclare);
		Integer i = informationServer.deleteProject(porjectDeclare);
        if(i != 0) {
            return new JsonResult();
        }
        throw new ServiceException("删除失败");
	}
	
    @ResponseBody
    @RequestMapping("updateAll_planSchedule")
    public JsonResult updateAllplanSchedule(PorjectDeclare porjectDeclare) {
        System.out.println("PlanController.all_planSchedule()");
        System.out.println(porjectDeclare);
        Integer i = informationServer.updateAllplanSchedule(porjectDeclare);
        if(i == 1) {
            return new JsonResult();
        }
        throw new ServiceException("修改失败");
    }
    /**
     * 查询单个已完成项目
     * @param porjectDeclare
     * @return
     */
    @ResponseBody
    @RequestMapping("selectOneProjectInfo")
    public JsonResult selectOneProjectInfo(PorjectDeclare porjectDeclare) {
        PorjectDeclare newPorjectDeclare = informationServer.selectOneProjectInfo(porjectDeclare);
        return new JsonResult(newPorjectDeclare);
    }
}
