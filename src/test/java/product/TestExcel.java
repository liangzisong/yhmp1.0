package product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

public class TestExcel/* extends TestBean*/ {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    @Test
    public void test() throws IOException {
      //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("所有人员信息");
        
        //创建HSSFRow对象       行
        HSSFRow row = sheet.createRow(0);
        //创建HSSFCell对象    列
        HSSFCell cell=row.createCell(0);
        //设置单元格的值        值
        cell.setCellValue("单元格中的中文");
      //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
        HSSFCell cell1=row.createCell(6);
        cell1.setCellValue("er");
        //输出Excel文件
        FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.flush();
            

    }
 }