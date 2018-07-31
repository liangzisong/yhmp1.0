package com.yhmp.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.web.JsonResult;
import com.yhmp.project.entity.PorjectDeclare;
import com.yhmp.system.entity.User;
import com.yhmp.system.service.UserServer;
/**
 * 人员管理控制器
 * @author Liang
 *
 */
@Controller
@RequestMapping("/staffManage/")
public class StffManageController {

	@Autowired
	private UserServer userServer;
	
	@RequestMapping("listUI")
	public String listUI(@RequestParam(value="user_id") String userId,@RequestParam(value="user_name") String username) {
		System.out.println("==人员管理控制器==");
		return "system/StffManage";
	}
	
	@ResponseBody
	@RequestMapping("selectUser")
	public JsonResult selectUser(User user) {
	    System.out.println("=========================StffManageController.selectUser()=============================");
	    System.out.println(user);
//		if(userServer.selectUser(user) instanceof User) {
//		    System.out.println("============================================userServer.selectUser(user) instanceof User===========================================");
//		    System.out.println((Object)userServer.selectUser(user));
//			return new JsonResult(userServer.selectUser(user));
//		}
		
		List<User> list = userServer.selectUser(user);
		System.out.println("查询出所有人员了");
		return new JsonResult(list);
	}
	
	@ResponseBody
	@RequestMapping("selectOneUser")
	public JsonResult selectOneUser(@RequestParam("pk_id")Integer pk_id) {
		System.out.println("StffManageController.selectOneUser()");
		System.out.println("u.getId()="+pk_id);
		User user = new User();
		user.setPk_id(pk_id);
		User u = userServer.selectUser(user).get(0);
		
		System.out.println("查询出人员了");
		return new JsonResult(u);
	}
	@ResponseBody
	@RequestMapping("addUser")
	public JsonResult addUser(User user) {
		System.out.println("StffManageController.addUser()");
		System.out.println("USER="+user);
		System.out.println("user.getDomicile()="+user.getDomicile());
		String state = userServer.addUser(user);
		System.out.println("state==="+state);
		return new JsonResult(state);
	}
	@ResponseBody
	@RequestMapping("editUser")
	public JsonResult editUser(User user) {
		System.out.println("StffManageController.editUser()");
		System.out.println("USER="+user);
		System.out.println("user.getDomicile()="+user.getDomicile());
		String state = userServer.editUser(user);
		System.out.println("state==="+state);
		return new JsonResult(state);
	}
	
	@ResponseBody
	@RequestMapping("deleteUser")
	public JsonResult deleteUser(String pk_id) {
		System.out.println("id==="+pk_id);
		String state = userServer.deleteUser(pk_id);
		System.out.println("state==="+state);
		return new JsonResult(state);
	}
	
}
