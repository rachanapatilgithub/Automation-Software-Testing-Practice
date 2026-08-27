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
import org.openqa.selenium.support.ui.Select;

public class AddUserTest {
	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		FileInputStream ff = new FileInputStream("data.properties");

		Properties pp = new Properties();
		pp.load(ff);

		String browsername = pp.getProperty("browser");
		String loginpageurl = pp.getProperty("loginurl");
		String adduserurl = pp.getProperty("adduserurl");

		System.out.println("Browser - " + browsername);
		System.out.println("Login URL - " + loginpageurl);
		System.out.println("Add User URL - " + adduserurl);

		if (browsername.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		// step 1 - login first, Add User page is inside the dashboard
		driver.get(loginpageurl);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");

		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("123456");

		WebElement siginbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button"));
		siginbutton.click();

		System.out.println("Login done, now on dashboard - " + driver.getCurrentUrl());

		// step 2 - add users using data from the Excel sheet
		FileInputStream fp = new FileInputStream("src\\test\\resources\\Test Data.xlsx");

		Workbook ww = new XSSFWorkbook(fp);
		Sheet sh = ww.getSheet("AddUser");

		int rowcount = sh.getPhysicalNumberOfRows();

		for (int i = 1; i < rowcount; i++) {

			driver.get(adduserurl);

			Row rr = sh.getRow(i);

			String username = rr.getCell(0).getStringCellValue();
			String mobile = rr.getCell(1).getStringCellValue();
			String useremail = rr.getCell(2).getStringCellValue();
			String course = rr.getCell(3).getStringCellValue();
			String gender = rr.getCell(4).getStringCellValue();
			String state = rr.getCell(5).getStringCellValue();
			String pwd = rr.getCell(6).getStringCellValue();

			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("mobile")).sendKeys(mobile);
			driver.findElement(By.id("email")).sendKeys(useremail);
			driver.findElement(By.id("course")).sendKeys(course);
			driver.findElement(By.id(gender)).click();

			Select stateDropdown = new Select(driver.findElement(By.xpath("//form[1]//select")));
			stateDropdown.selectByVisibleText(state);

			driver.findElement(By.id("password")).sendKeys(pwd);

			driver.findElement(By.id("submit")).click();

			System.out.println("Add User form submitted - Username: " + username + ", Email: " + useremail);
		}

		driver.quit();
	}
}
