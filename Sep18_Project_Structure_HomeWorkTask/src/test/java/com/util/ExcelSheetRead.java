package com.util;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetRead {
    public static String getData(int row, int cell) {
        String data = "";
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/login.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            data = sheet.getRow(row).getCell(cell).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}