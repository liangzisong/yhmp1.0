package com.yhmp.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.exception.ServiceException;
import com.yhmp.common.web.JsonResult;
import com.yhmp.project.entity.ProjectSummary;
import com.yhmp.project.service.ProjectSummaryServer;
/**
 * 项目总结
 * @author Liang
 *
 */
@Controller
@RequestMapping("/summary/")
@Transactional(rollbackFor=Exception.class)
public class ProjectSummaryController {

    @Autowired
    private ProjectSummaryServer projectSummaryServer;
    @ResponseBody
    @RequestMapping("addProjectSummary")
    public JsonResult addProjectSummary(ProjectSummary projectSummary) {
        Integer i = projectSummaryServer.addProjectSummary(projectSummary);
        if(i == 1) {
            return new JsonResult();
        }else {
            throw new ServiceException("修改失败");
        }
    }
    
    @ResponseBody
    @RequestMapping("updateProjectSummary")
    public JsonResult updateProjectSummary(ProjectSummary projectSummary) {
        Integer i = projectSummaryServer.updateProjectSummary(projectSummary);
        if(i == 1) {
            return new JsonResult();
        }else {
            throw new ServiceException("修改失败");
        }
        
    } 
    
    @ResponseBody
    @RequestMapping("selectProjectSummary")
    public JsonResult selectProjectSummary(ProjectSummary projectSummary) {
        System.out.println("ProjectSummaryController.selectProjectSummary()");
        System.out.println(projectSummary.getFk_project_id());
        ProjectSummary newProjectSummary = projectSummaryServer.selectProjectSummary(projectSummary);
        return new JsonResult(newProjectSummary);
    } 
}
