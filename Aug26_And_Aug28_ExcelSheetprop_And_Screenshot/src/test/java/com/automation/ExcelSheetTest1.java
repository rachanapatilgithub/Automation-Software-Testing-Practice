package com.automation;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ExcelSheetTest1 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/index.html");

		FileInputStream fp = new FileInputStream("src\\test\\resources\\Test Data.xlsx");

		Workbook ww = new XSSFWorkbook(fp);
		Sheet sh = ww.getSheet("Login");

		Row rr = sh.getRow(1);

		DataFormatter dd = new DataFormatter();

		String username = dd.formatCellValue(rr.getCell(0));
		String pwd = dd.formatCellValue(rr.getCell(1));

		System.out.println(username + "  " + pwd);

		WebElement username1 = driver.findElement(By.id("email"));
		username1.sendKeys(username);

		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(pwd);

		driver.quit();
	}
}
