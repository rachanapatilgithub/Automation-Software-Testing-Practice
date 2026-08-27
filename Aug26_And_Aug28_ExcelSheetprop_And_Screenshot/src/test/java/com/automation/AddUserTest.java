package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddUserTest {
	public static void main(String[] args) throws Exception {

		ConfigReader config = new ConfigReader();
		WebDriver driver = DriverFactory.getDriver(config.getBrowser());

		// step 1 - login first, Add User page is inside the dashboard
		driver.get(config.getLoginUrl());

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button")).click();

		System.out.println("Login done, now on dashboard - " + driver.getCurrentUrl());

		// step 2 - add users using data from the Excel sheet
		String adduserurl = config.getAddUserUrl();
		ExcelUtils excel = new ExcelUtils("AddUser");
		int rowcount = excel.getRowCount();

		for (int i = 1; i < rowcount; i++) {

			driver.get(adduserurl);

			String username = excel.getCellData(i, 0);
			String mobile = excel.getCellData(i, 1);
			String email = excel.getCellData(i, 2);
			String course = excel.getCellData(i, 3);
			String gender = excel.getCellData(i, 4);
			String state = excel.getCellData(i, 5);
			String pwd = excel.getCellData(i, 6);

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

		driver.quit();
	}
}
