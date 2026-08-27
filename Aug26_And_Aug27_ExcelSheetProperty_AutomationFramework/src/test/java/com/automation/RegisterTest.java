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

public class RegisterTest {
	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		FileInputStream ff = new FileInputStream("data.properties");

		Properties pp = new Properties();
		pp.load(ff);

		String browsername = pp.getProperty("browser");
		String registerpageurl = pp.getProperty("registerurl");

		System.out.println(browsername);
		System.out.println(registerpageurl);

		if (browsername.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(registerpageurl);

		FileInputStream fp = new FileInputStream("src\\test\\resources\\Test Data.xlsx");

		Workbook ww = new XSSFWorkbook(fp);
		Sheet sh = ww.getSheet("Register");

		int rowcount = sh.getPhysicalNumberOfRows();

		for (int i = 1; i < rowcount; i++) {

			// registration succeeds on this site and redirects to index.html (login page), so reload before every row
			driver.get(registerpageurl);

			Row rr = sh.getRow(i);

			String name = rr.getCell(0).getStringCellValue();
			String mobile = rr.getCell(1).getStringCellValue();
			String email = rr.getCell(2).getStringCellValue();
			String pwd = rr.getCell(3).getStringCellValue();

			WebElement nameField = driver.findElement(By.id("name"));
			nameField.sendKeys(name);

			WebElement mobileField = driver.findElement(By.id("mobile"));
			mobileField.sendKeys(mobile);

			WebElement emailField = driver.findElement(By.id("email"));
			emailField.sendKeys(email);

			WebElement passField = driver.findElement(By.id("password"));
			passField.sendKeys(pwd);

			WebElement registerbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div[1]/button"));
			registerbutton.click();

			String url = driver.getCurrentUrl();
			if (url.contains("index.html")) {
				System.out.println("Register SUCCESS - with " + name + " and " + email);
			} else {
				System.out.println("Register FAILED - with " + name + " and " + email);
			}
		}

		driver.quit();
	}
}
