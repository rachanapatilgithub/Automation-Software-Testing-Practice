package com.automation;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static String getData(String sheetName, int row, int column) {
		String value = "";
		try {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);

			// DataFormatter instead of getStringCellValue() - some cells (mobile
			// number, a numeric-looking password) are stored as numbers, and
			// getStringCellValue() throws on a numeric cell
			DataFormatter df = new DataFormatter();
			value = df.formatCellValue(sheet.getRow(row).getCell(column));

			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
