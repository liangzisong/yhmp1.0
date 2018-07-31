package com.yhmp.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhmp.common.web.JsonResult;
import com.yhmp.system.entity.User;
import com.yhmp.system.service.UserServer;
/**
 * 登陆控制器
 * @author Liang
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserServer userServer;
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("登录");
		return "login";
	}
	@ResponseBody
	@RequestMapping("/onLogin")
	public JsonResult onLogin(User user) {
		System.out.println("用户输入userName="+user.getUsername());
		System.out.println("用户输入password="+user.getPassword());
//		User newUser = new User();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(user.getPassword());
		System.out.println("====================================================================================================================");
		System.out.println(userServer.selectUser(user).size());
		List<User> list = userServer.selectUser(user);
	      if(list == null) {
	            System.out.println("User等于null");
	            return new JsonResult("000");
	        }
	       if(list.size() == 0) {
	              System.out.println("User等于null");
	              return new JsonResult("000");
	          }
	      if(list.get(0) == null) {
              System.out.println("User等于null");
              return new JsonResult("000");
          }

		System.out.println(userServer.selectUser(user));
		for(int i = 0;i<userServer.selectUser(user).size();i++) {
		    System.out.println(userServer.selectUser(user).get(i));
		}
		
		//拿到第一条，也是唯一一条
		//User users = list.get(0);

	    System.out.println("用户id="+list.get(0).getPk_id());
	    if(( list.get(0)).getPk_id() instanceof Integer) {
	        System.out.println("===Integer===");
	    }
		return new JsonResult(list.get(0));

//		}else {
//			System.out.println("User等于null");
//			return new JsonResult(new ServiceException("用户名或密码错误！"));
//		}		
	}
}
