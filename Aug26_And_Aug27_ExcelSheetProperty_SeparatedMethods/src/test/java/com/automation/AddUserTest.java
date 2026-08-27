package com.automation;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUserTest {

	public static void main(String[] args) throws Exception {
		Properties pp = Utility.getProperties();
		String browsername = pp.getProperty("browser");
		String loginpageurl = pp.getProperty("loginurl");
		String adduserurl = pp.getProperty("adduserurl");

		WebDriver driver = Utility.getDriver(browsername);

		login(driver, loginpageurl);
		addUsers(driver, adduserurl);

		driver.quit();
	}

	public static void login(WebDriver driver, String loginpageurl) {
		// Add User page is inside the dashboard, so log in first
		driver.get(loginpageurl);

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button")).click();

		System.out.println("Login done, now on dashboard - " + driver.getCurrentUrl());
	}

	public static void addUsers(WebDriver driver, String adduserurl) throws Exception {
		Sheet sh = Utility.getSheet("AddUser");
		int rowcount = sh.getPhysicalNumberOfRows();

		for (int i = 1; i < rowcount; i++) {

			driver.get(adduserurl);

			Row rr = sh.getRow(i);
			String username = rr.getCell(0).getStringCellValue();
			String mobile = rr.getCell(1).getStringCellValue();
			String email = rr.getCell(2).getStringCellValue();
			String course = rr.getCell(3).getStringCellValue();
			String gender = rr.getCell(4).getStringCellValue();
			String state = rr.getCell(5).getStringCellValue();
			String pwd = rr.getCell(6).getStringCellValue();

			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("mobile")).sendKeys(mobile);
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("course")).sendKeys(course);
			driver.findElement(By.id(gender)).click();

			Select stateDropdown = new Select(driver.findElement(By.xpath("//form[1]//select")));
			stateDropdown.selectByVisibleText(state);

			driver.findElement(By.id("password")).sendKeys(pwd);

			driver.findElement(By.id("submit")).click();

			System.out.println("Add User form submitted - Username: " + username + ", Email: " + email);
		}
	}
}
