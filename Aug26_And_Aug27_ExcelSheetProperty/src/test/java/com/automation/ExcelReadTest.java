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

public class ExcelReadTest {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/index.html");

		FileInputStream fp = new FileInputStream("src\\test\\resources\\Test Data.xlsx");

		Workbook ww = new XSSFWorkbook(fp);
		Sheet sh = ww.getSheet("Login");

		int rowcount = sh.getPhysicalNumberOfRows();
		DataFormatter df = new DataFormatter();

		for (int i = 1; i < rowcount; i++) {

			Row rr = sh.getRow(i);

			String usename = df.formatCellValue(rr.getCell(0));
			String pwd = df.formatCellValue(rr.getCell(1));

			//System.out.println("Username is - " + usename);
			//System.out.println("Password is - " + pwd);

			WebElement username = driver.findElement(By.id("email"));
			username.sendKeys(usename);

			WebElement pass = driver.findElement(By.id("password"));
			pass.sendKeys(pwd);

			WebElement siginbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button"));
			siginbutton.click();
		}

		driver.quit();
	}
}
