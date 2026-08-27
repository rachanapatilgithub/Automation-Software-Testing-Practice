package com.automation;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private Sheet sheet;

	public ExcelUtils(String sheetName) throws Exception {
		FileInputStream fp = new FileInputStream("src\\test\\resources\\Test Data.xlsx");
		Workbook workbook = new XSSFWorkbook(fp);
		sheet = workbook.getSheet(sheetName);
	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public String getCellData(int rowNum, int colNum) {
		Row row = sheet.getRow(rowNum);
		return row.getCell(colNum).getStringCellValue();
	}
}
