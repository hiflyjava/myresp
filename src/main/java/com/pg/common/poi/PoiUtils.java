package com.pg.common.poi;

import com.pg.common.dto.out.OriginalAttenceLogOut;
import com.pg.common.dto.out.StaffsManyDayAttenceOut;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2018/1/16.
 */
public class PoiUtils {

    public static ResponseEntity<byte[]> exportEmp2Excel(List<StaffsManyDayAttenceOut> attenceOuts) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("员工考勤统计");
            //3.2设置文档管理员
            dsi.setManager("admin");
            //3.3设置组织机构
            dsi.setCompany("pg-attence-system");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("员工考勤统计表");
            //4.2.设置文档标题
            si.setTitle("员工考勤统计");
            //4.3 设置文档作者
            si.setAuthor("pg-attence-system");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("pg-attence-system 考勤统计表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 5 * 256);
            sheet.setColumnWidth(1, 12 * 256);
            sheet.setColumnWidth(2, 15 * 256);
            sheet.setColumnWidth(3, 15 * 256);
            sheet.setColumnWidth(4, 15 * 256);
            sheet.setColumnWidth(5, 20 * 256);
            sheet.setColumnWidth(6, 15 * 256);
            sheet.setColumnWidth(7, 15 * 256);
            for(int a=0;a<attenceOuts.get(0).getAttenceOutList().size();a++){
                sheet.setColumnWidth(8+a, 16 * 256);
            }


            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("编号");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("部门");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("职位");
            cell2.setCellStyle(headerStyle);
                  HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("Name");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("SURNAME");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("机器号");
            cell5.setCellStyle(headerStyle);
            HSSFCell cell6 = headerRow.createCell(6);
            cell6.setCellValue("上班时间");
            cell6.setCellStyle(headerStyle);
            HSSFCell cell7 = headerRow.createCell(7);
            cell7.setCellValue("下班时间");
            cell7.setCellStyle(headerStyle);
            for(int a=0;a<attenceOuts.get(0).getAttenceOutList().size();a++){
                HSSFCell cell8 = headerRow.createCell(8+a);
                cell8.setCellValue(attenceOuts.get(0).getAttenceOutList().get(a).getDates());
                cell8.setCellStyle(headerStyle);
            }


            //6.装数据
            for (int i = 0; i < attenceOuts.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                StaffsManyDayAttenceOut attenceOut = attenceOuts.get(i);
                row.createCell(0).setCellValue(attenceOut.getUserNo());
                row.createCell(1).setCellValue(attenceOut.getDname());
                row.createCell(2).setCellValue(attenceOut.getPname());
                row.createCell(3).setCellValue(attenceOut.getName());
//                HSSFCell birthdayCell = row.createCell(4);
//                birthdayCell.setCellValue(emp.getBirthday());
//                birthdayCell.setCellStyle(dateCellStyle);
                row.createCell(4).setCellValue(attenceOut.getSurname());
                row.createCell(5).setCellValue(attenceOut.getDeviceNo());
                row.createCell(6).setCellValue(attenceOut.getStartTime());
                row.createCell(7).setCellValue(attenceOut.getEndTime());
                for(int a=0;a<attenceOut.getAttenceOutList().size();a++){
                    row.createCell(8+a).setCellValue(attenceOut.getAttenceOutList().get(a).getDatas());
                }

            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("员工考勤表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }




    public static ResponseEntity<byte[]> exportEmp2Excel2(List<OriginalAttenceLogOut> logOuts) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("员工考勤统计");
            //3.2设置文档管理员
            dsi.setManager("admin");
            //3.3设置组织机构
            dsi.setCompany("pg-attence-system");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("员工考勤统计表");
            //4.2.设置文档标题
            si.setTitle("员工考勤统计");
            //4.3 设置文档作者
            si.setAuthor("pg-attence-system");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("pg-attence-system 考勤原始数据统计表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 5 * 256);
            sheet.setColumnWidth(1, 12 * 256);
            sheet.setColumnWidth(2, 15 * 256);
            sheet.setColumnWidth(3, 15 * 256);
            sheet.setColumnWidth(4, 15 * 256);
            sheet.setColumnWidth(5, 20 * 256);
            //sheet.setColumnWidth(6, 15 * 256);
           // sheet.setColumnWidth(7, 15 * 256);
            for(int a=0;a<logOuts.get(0).getOriginalAttenceDates().size();a++){
                sheet.setColumnWidth(6+a, 16 * 256);
            }


            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("编号");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("部门");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("职位");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("Name");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("SURNAME");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("机器号");
            cell5.setCellStyle(headerStyle);
//            HSSFCell cell6 = headerRow.createCell(6);
//            cell6.setCellValue("上班时间");
//            cell6.setCellStyle(headerStyle);
//            HSSFCell cell7 = headerRow.createCell(7);
//            cell7.setCellValue("下班时间");
//            cell7.setCellStyle(headerStyle);
            for(int a=0;a<logOuts.get(0).getOriginalAttenceDates().size();a++){
                HSSFCell cell8 = headerRow.createCell(6+a);
                cell8.setCellValue(logOuts.get(0).getOriginalAttenceDates().get(a).getDates());
                cell8.setCellStyle(headerStyle);
            }


            //6.装数据
            for (int i = 0; i < logOuts.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                OriginalAttenceLogOut logOut = logOuts.get(i);
                row.createCell(0).setCellValue(logOut.getStaffNo());
                row.createCell(1).setCellValue(logOut.getDname());
                row.createCell(2).setCellValue(logOut.getPname());
                row.createCell(3).setCellValue(logOut.getStaffName());
//                HSSFCell birthdayCell = row.createCell(4);
//                birthdayCell.setCellValue(emp.getBirthday());
//                birthdayCell.setCellStyle(dateCellStyle);
                row.createCell(4).setCellValue(logOut.getStaffSurname());
                row.createCell(5).setCellValue(logOut.getDeviceNo());
               // row.createCell(6).setCellValue(attenceOut.getStartTime());
              //  row.createCell(7).setCellValue(attenceOut.getEndTime());
                for(int a=0;a<logOut.getOriginalAttenceDates().size();a++){
                    row.createCell(6+a).setCellValue(logOut.getOriginalAttenceDates().get(a).getDatas());
                }

            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("原始考勤记录表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);


    }
}
