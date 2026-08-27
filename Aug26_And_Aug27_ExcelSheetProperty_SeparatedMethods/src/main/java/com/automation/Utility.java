package com.automation;

import java.io.FileInputStream;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Utility {

	public static Properties getProperties() throws Exception {
		FileInputStream ff = new FileInputStream("data.properties");
		Properties pp = new Properties();
		pp.load(ff);
		return pp;
	}

	public static WebDriver getDriver(String browserName) {
		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		return driver;
	}

	public static Sheet getSheet(String sheetName) throws Exception {
		FileInputStream fp = new FileInputStream("src\\test\\resources\\Test Data.xlsx");
		Workbook ww = new XSSFWorkbook(fp);
		return ww.getSheet(sheetName);
	}
}
