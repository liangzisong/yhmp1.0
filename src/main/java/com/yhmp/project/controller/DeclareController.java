package com.yhmp.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.exception.ServiceException;
import com.yhmp.common.web.JsonResult;
import com.yhmp.project.entity.PorjectDeclare;
import com.yhmp.project.service.DeclareServer;
/**
 * 项目申报交接控制器
 * @author liang
 *
 */
@Controller
@RequestMapping("/declare/")
@Transactional(rollbackFor=Exception.class)
public class DeclareController {

	@Autowired
	private DeclareServer declareServer; 
	@RequestMapping("listUI")
	public String listUI(@RequestParam(value="user_id") String userId,@RequestParam(value="user_name") String username) {
		System.out.println("进入declare.listUI");
		//System.out.println("user_id="+(String)userId);
		//System.out.println("user_id="+(Integer)userId);
		System.out.println("userId="+userId);
		return "project/Declare";
	}
	
	@ResponseBody
	@RequestMapping("disposeSubmit")
	public JsonResult disposeSubmit(PorjectDeclare porjectDeclare) {
	    Integer i = declareServer.insertPorjectDeclare(porjectDeclare);
		if(i == 1) {
			return new JsonResult();
		}else {
			throw new ServiceException("添加失败");
		}
	}
} 