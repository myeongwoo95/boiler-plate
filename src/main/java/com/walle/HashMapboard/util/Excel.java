package com.walle.HashMapboard.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/*
   @RequestMapping(value = "/calculation/calcComplExcelDownload.json", method = RequestMethod.POST)
   public void calcComplExcelDownload(@RequestParam HashMap<String, String> prm, HttpServletResponse response) throws Exception{
       prm.put("calcYn", "Y");
       List selectComplCalcList = calculationService.selectCalcListNoPaging(prm);
       String[] rowNameArr = {"번호", "작업자", "최종작업일자", "검수합격", "검수수정합격","정산금액","정산일자"};
       String[] mapNameArr = {"ROWNUM", "regName", "regDate", "Y", "U", "calcAccount", "regDate"};

       ExcelListDownload.excelDownload(response, selectComplCalcList, rowNameArr, mapNameArr);
    }
*/

public class Excel {
    public static void excelDownload(HttpServletResponse response, List fileList, List<String> columnList, List<String> keyList) throws IOException {

        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        //테이블 헤더용 스타일
        CellStyle headStyle = workbook.createCellStyle();

        //가는 경계선
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        for(int i=0; i<columnList.size(); i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(columnList.get(i));
        }

        for(int i = 0; i < fileList.size(); i++) {
            Map map = (Map) fileList.get(i);
            Row bodyRow = sheet.createRow(rowIndex++);

            for (int j = 0; j < keyList.size(); j++) {
                Cell bodyCell = bodyRow.createCell(j);
                bodyCell.setCellValue(map.get(keyList.get(j)).toString());
            }
        }

        //엑셀 출력
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelList.xls");
        workbook.write(response.getOutputStream());
    }
    

}
    