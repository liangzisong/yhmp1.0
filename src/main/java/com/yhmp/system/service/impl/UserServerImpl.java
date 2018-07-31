package com.yhmp.system.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhmp.system.dao.UserDao;
import com.yhmp.system.entity.User;
import com.yhmp.system.service.UserServer;
/**
 * 用户server
 * @author liang
 *
 */
@Service
public class UserServerImpl implements UserServer {

	@Autowired
	private UserDao userDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List selectUser(User user) {
		List<User> u = userDao.selectUser(user);
		System.out.println("u.size()="+u.size());
			
			System.out.println("查询出多条");
			if(u.size()>1) {
	            //屏蔽显示管理员
	            Iterator<User> it = u.iterator();
	            while (it.hasNext()) {
	                User x = it.next();
	                //管理员id为-1
	                if(-1 == x.getPk_id()) {
	                    it.remove();
	                }
	            }
			}

			return u;
	}
	@Override
	public String updateUser(User user) {
		Integer i = userDao.updateUser(user);
		if(i == 1) {
			return "修改成功";
		}
		return "修改失败";
	}
	@Override
	public String addUser(User user) {
		Integer i = userDao.addUser(user);
		if(i == 1) {
			return "添加成功";
		}
		return "添加失败";
	}
	@Override
	public String editUser(User user) {
		Integer i = userDao.editUser(user);
		if(i == 1) {
			return "修改成功";
		}
		return "修改失败";
	}
	@Override
	public String deleteUser(String id) {
		try {
			Integer userId = Integer.valueOf(id);
			Integer i = userDao.deleteUser(userId);
			if(i == 1) {
				return "删除成功";
			}
			return "删除失败";
		}catch (NumberFormatException e) {
			return "删除失败";
		}

	}

}
