package org.zhyan.fixed.excelview;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.zhyan.fixed.bean.Fixed_net_asset;




public class FixedNetAssetExcelView {

    String[] fixedNetAssetExcelHeader = { "总页", "分页", "编号","名称","结构规格","计量单位","使用年限","折旧率(年)","折旧率(月)","设备购入时间"};  
    public HSSFWorkbook FixedNetAssetsExport(List<Fixed_net_asset> list) {  
        HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet("String");  
        HSSFRow row = sheet.createRow((int) 0);  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
  
        for (int i = 0; i < fixedNetAssetExcelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(fixedNetAssetExcelHeader[i]);  
            cell.setCellStyle(style);  
            sheet.autoSizeColumn(i);  
         // sheet.SetColumnWidth(i, 100 * 256);  
        }  
  
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow(i + 1);  
            String total = list.get(i).getTotal();
            String page = list.get(i).getPage();
            String code = list.get(i).getCode();
            String name = list.get(i).getName();
            String ssize = list.get(i).getSsize();
            String units = list.get(i).getUnits();
            String life = "";
            String year = "";
            String month = "";
            if(list.get(i).getLife() != null){
            	life = list.get(i).getLife().toString();
            }
            if(list.get(i).getYear() != null){
            	year = list.get(i).getYear().toString();
            }
            if(list.get(i).getMonth() != null){
            	month = list.get(i).getMonth().toString();
            }
            row.createCell(0).setCellValue(total);          
            row.createCell(1).setCellValue(page);
            row.createCell(2).setCellValue(code);
            row.createCell(3).setCellValue(name); 
            row.createCell(4).setCellValue(ssize); 
            row.createCell(5).setCellValue(units); 
            row.createCell(6).setCellValue(life); 
            row.createCell(7).setCellValue(year); 
            row.createCell(8).setCellValue(month); 
             
            
        }  
        return wb;  
    } 




}
