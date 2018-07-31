package com.yhmp.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.web.JsonResult;
import com.yhmp.project.entity.PreservationProjectVO;
import com.yhmp.project.service.PreservationProjecServer;
/**
 * 点击项目存档
 * @author Liang
 *
 */
@Controller
@RequestMapping("/preservationProject/")
public class PreservationProjectController {

    @Autowired
    private PreservationProjecServer preservationProjecServer;
    
    @RequestMapping("listUI")
    public String listUI(@RequestParam(value="user_id") String userId,@RequestParam(value="user_name") String username) {
        System.out.println("PreservationProjectController.listUI()");
        return "project/preservationProject";
    }
    
    @ResponseBody
    @RequestMapping("selectPreservationProject")
    public JsonResult onePreservationProject(PreservationProjectVO preservationProjectVO) {
        System.out.println("InformationController.selectInformation()===="+preservationProjectVO);
//        //单个项目详细信息
//        if(preservationProjecServer.selectPreservationProject(preservationProjectVO) instanceof PreservationProjectVO) {
//            System.out.println("查询出单个项目");
//            PreservationProjectVO pd = preservationProjecServer.selectPreservationProject(preservationProjectVO);
//            List<PreservationProjectVO> list = new ArrayList<PreservationProjectVO>();
//            list.add(pd);
//            System.out.println("pd="+pd);
//            return new JsonResult(list);
//        }
        //多个项目
        List<PreservationProjectVO> list = preservationProjecServer.selectPreservationProject(preservationProjectVO);
        System.out.println("======console.porject======");
        for(PreservationProjectVO p : list) {
            System.out.println(p);
        }
        System.out.println("查询出多个项目");
        return new JsonResult(list);
    }
    
}
