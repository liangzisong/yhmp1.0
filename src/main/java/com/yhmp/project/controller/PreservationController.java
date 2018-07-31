package com.yhmp.project.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.exception.ServiceException;
import com.yhmp.common.web.JsonResult;
import com.yhmp.project.entity.ProjectPreservation;
import com.yhmp.project.service.ProjectPreservationIngServer;
/**
 * 保存项目总结与查看
 * @author Liang
 *
 */
@Controller
@RequestMapping("/preservation/")
@Transactional(rollbackFor=Exception.class)
public class PreservationController {

    @Autowired
    private ProjectPreservationIngServer projectPreservationServer;
    
    @RequestMapping("listUI")
    public String listUI(@Param("user_id") String userId) {
        System.out.println("PreservationController.listUI()");
        return "project/preservation";
    }
    
    @ResponseBody
    @RequestMapping("savePreservation")
    public JsonResult savePreservation(ProjectPreservation projectPreservation) {
        System.out.println("=================");
        System.out.println(projectPreservation);
        System.out.println("PreservationController.savePreservation()");
        Integer i = projectPreservationServer.saveProjectPreservation(projectPreservation);
        if(i ==1 ) {
            return new JsonResult("添加成功");
        }else {
            throw new ServiceException("添加失败");
        }
        
    }
    
    @ResponseBody
    @RequestMapping("selectPreservation")
    public JsonResult selectPreservation(ProjectPreservation projectPreservation) {
        System.out.println("=================");
        System.out.println(projectPreservation);
        System.out.println("PreservationController.savePreservation()");
        ProjectPreservation newProjectPreservation = projectPreservationServer.selectPreservation(projectPreservation);
        return new JsonResult(newProjectPreservation);
    }
}
