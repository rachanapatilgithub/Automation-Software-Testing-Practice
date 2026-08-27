package com.automation;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PropertieFileReadTest {
	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		FileInputStream ff = new FileInputStream("data.properties");

		Properties pp = new Properties();
		pp.load(ff);

		String browsername = pp.getProperty("browser");
		String loginpageurl = pp.getProperty("loginurl");

		System.out.println(browsername);
		System.out.println(loginpageurl);

		if (browsername.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(loginpageurl);

		FileInputStream fp = new FileInputStream("src\\test\\resources\\Test Data.xlsx");

		Workbook ww = new XSSFWorkbook(fp);
		Sheet sh = ww.getSheet("Login");

		Row rr = sh.getRow(1);

		String username = rr.getCell(0).getStringCellValue();
		String pwd = rr.getCell(1).getStringCellValue();

		WebElement usernameField = driver.findElement(By.id("email"));
		usernameField.sendKeys(username);

		WebElement passField = driver.findElement(By.id("password"));
		passField.sendKeys(pwd);

		driver.quit();
	}
}
