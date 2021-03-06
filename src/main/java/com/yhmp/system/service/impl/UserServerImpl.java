package com.yhmp.system.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
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
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    
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
	public Integer updateUser(User user) {
		Integer i = userDao.updateUser(user);
		return i;
	}
	@Override
	public Integer addUser(User user) {
		Integer i = userDao.addUser(user);
		return i;
	}
	@Override
	public Integer editUser(User user) {
		Integer i = userDao.editUser(user);
		return i;
	}
	@Override
	public Integer deleteUser(String id) {
		try {
			Integer userId = Integer.valueOf(id);
			Integer i = userDao.deleteUser(userId);
			return i;
		}catch (NumberFormatException e) {
			return 0;
		}

	}
    @Override
    public String selectUserExcel(String url) {
        List<User> list = userDao.selectUser(new User());
        //创建HSSFWorkbook对象
      HSSFWorkbook wb = new HSSFWorkbook();
      //创建HSSFSheet对象
      HSSFSheet sheet = wb.createSheet("所有人员信息");
      
      //创建HSSFRow对象       行
      HSSFRow r0 = sheet.createRow(0);
      //创建HSSFCell对象    列
      HSSFCell r0c0=r0.createCell(0);
      //设置单元格的值        值
      r0c0.setCellValue("山东元鸿");
      //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
      sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
      HSSFRow r1 = sheet.createRow(1);
      HSSFCell r1c0 = r1.createCell(0);
      r1c0.setCellValue("姓名");
      HSSFCell r1c1 = r1.createCell(1);
      r1c1.setCellValue("职位");
      HSSFCell r1c2 = r1.createCell(2);
      r1c2.setCellValue("部门");
      HSSFCell r1c3 = r1.createCell(3);
      r1c3.setCellValue("个人手机");
      HSSFCell r1c4 = r1.createCell(4);
      r1c4.setCellValue("入职时间");
      HSSFCell r1c5 = r1.createCell(5);
      r1c5.setCellValue("入职状态");
      HSSFCell r1c6 = r1.createCell(6);
      r1c6.setCellValue("居住地");
      HSSFCell r1c7 = r1.createCell(7);
      r1c7.setCellValue("性别");
      HSSFCell r1c8 = r1.createCell(8);
      r1c8.setCellValue("年龄");
      for(int i=0;i<list.size();i++) {
          HSSFRow row = sheet.createRow(i+2);
          row.createCell(0).setCellValue(list.get(i).getUsername());
          row.createCell(1).setCellValue(list.get(i).getJob());
          row.createCell(2).setCellValue(list.get(i).getDepartment());
          row.createCell(3).setCellValue(Long.valueOf(list.get(i).getPhone()));
          row.createCell(4).setCellValue(list.get(i).getHiredate());
          row.createCell(5).setCellValue(list.get(i).getStatus()==0 ? "实习" : list.get(i).getStatus()==1 ? "在职" : "离职");
          row.createCell(6).setCellValue(list.get(i).getDomicile());
          row.createCell(7).setCellValue(list.get(i).getSex()==0 ? "女" : "男");
          row.createCell(8).setCellValue(Integer.valueOf(list.get(i).getAge()));
//          sheet.autoSizeColumn(i+2);
      }
      
    //输出Excel文件
    FileOutputStream output = null;
    String localTime = LocalTime.now().toString();
    try {
        output = new FileOutputStream(url+localTime+"user.xls");
        wb.write(output);
        output.flush();
        wb.close();
        return localTime+"user.xls";
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }

    }

}
