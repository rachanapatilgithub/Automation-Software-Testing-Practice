package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {
	public static void main(String[] args) throws Exception {

		ConfigReader config = new ConfigReader();
		WebDriver driver = DriverFactory.getDriver(config.getBrowser());

		String loginpageurl = config.getLoginUrl();
		driver.get(loginpageurl);

		ExcelUtils excel = new ExcelUtils("Login");
		int rowcount = excel.getRowCount();

		for (int i = 1; i < rowcount; i++) {

			// login succeeds on this site and navigates to dashboard.html, so each row needs a fresh page load
			driver.get(loginpageurl);

			String usename = excel.getCellData(i, 0);
			String pwd = excel.getCellData(i, 1);

			WebElement username = driver.findElement(By.id("email"));
			username.sendKeys(usename);

			WebElement pass = driver.findElement(By.id("password"));
			pass.sendKeys(pwd);

			WebElement siginbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button"));
			siginbutton.click();

			String url = driver.getCurrentUrl();
			if (url.contains("dashboard.html")) {
				System.out.println("Login SUCCESS - with " + usename + " and " + pwd);
			} else {
				System.out.println("Login FAILED - with " + usename + " and " + pwd);
			}
		}

		driver.quit();
	}
}
