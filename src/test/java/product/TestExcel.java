package product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import com.yhmp.system.entity.User;

public class TestExcel/* extends TestBean*/ {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    /*
     * r  row     行
     * c  column  列
     */
    @Test
    public void test() throws IOException {
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
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setUsername("测试er");
        user.setJob("abc");
        user.setDepartment("一部");
        user.setPhone("15581815165");
        user.setHiredate("2018-05-09");
        user.setStatus(1);
        user.setDomicile("山东");
        user.setSex(0);
        user.setAge("14");
        list.add(user);
        User user1 = new User();
        user1.setUsername("测试一");
        user1.setDepartment("一部");
        user1.setHiredate("2018-04-09");
        user1.setStatus(1);
        user1.setSex(0);
        user1.setAge("14");
        list.add(user1);
        
        for(int i=0;i<list.size();i++) {
            HSSFRow row = sheet.createRow(i+2);
            row.createCell(0).setCellValue(list.get(i).getUsername());
            row.createCell(1).setCellValue(list.get(i).getJob());
            row.createCell(2).setCellValue(list.get(i).getDepartment());
            row.createCell(3).setCellValue(list.get(i).getPhone());
            row.createCell(4).setCellValue(list.get(i).getHiredate());
            row.createCell(5).setCellValue(list.get(i).getStatus());
            row.createCell(6).setCellValue(list.get(i).getDomicile());
            row.createCell(7).setCellValue(list.get(i).getSex());
            row.createCell(8).setCellValue(list.get(i).getAge());
        }
        
        //输出Excel文件
        FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.flush();
        wb.close();

    }
 }