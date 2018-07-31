package com.yhmp.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 登陆控制器
 * @author liang
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.web.JsonResult;
@Controller
public class IndexController {

	@RequestMapping("/indexUI")
	public String indexUI(@RequestParam(value="date") String date 
	        ,@RequestParam(value="user_id") Integer id
	        ,@RequestParam(value="username") String username){
		System.out.println("indexUI");
	 	//两小时内不用登陆
//		if(state) {
			System.out.println("正常");
			System.out.println("username="+username+",id="+id);
			return "index";
//		}else {
//			System.out.println("异常");
//			return "login";
//		}
		//返回的字符串会对应一个/WEB-INF/pages/index.jsp页面
	}
	
	@ResponseBody
	@RequestMapping("/onIndex.oo")
	public JsonResult onIndex(HttpServletRequest request, HttpServletResponse response) {
	    System.out.println("IndexController.onIndex()");
	    System.out.println(request.getRemoteAddr());
        return null;
	}

}
