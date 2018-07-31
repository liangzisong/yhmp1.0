package com.yhmp.system.service;

import java.util.List;

import com.yhmp.system.entity.User;
/**
 * 用户server接口由具体实现类来实现业务
 * @author liang
 *
 */
public interface UserServer {

	List<User> selectUser(User user);
	String updateUser(User user);
	String addUser(User user);
	String editUser(User user);
	String deleteUser(String id);
}