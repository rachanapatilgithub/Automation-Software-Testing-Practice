package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterTest {
	public static void main(String[] args) throws Exception {

		ConfigReader config = new ConfigReader();
		WebDriver driver = DriverFactory.getDriver(config.getBrowser());

		String registerpageurl = config.getRegisterUrl();
		driver.get(registerpageurl);

		ExcelUtils excel = new ExcelUtils("Register");
		int rowcount = excel.getRowCount();

		for (int i = 1; i < rowcount; i++) {

			// registration succeeds on this site and redirects to index.html (login page), so reload before every row
			driver.get(registerpageurl);

			String name = excel.getCellData(i, 0);
			String mobile = excel.getCellData(i, 1);
			String email = excel.getCellData(i, 2);
			String pwd = excel.getCellData(i, 3);

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
