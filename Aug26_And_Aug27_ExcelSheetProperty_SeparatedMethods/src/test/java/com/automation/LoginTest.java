package com.automation;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		Properties pp = Utility.getProperties();
		String browsername = pp.getProperty("browser");
		String loginpageurl = pp.getProperty("loginurl");

		WebDriver driver = Utility.getDriver(browsername);

		login(driver, loginpageurl);

		driver.quit();
	}

	public static void login(WebDriver driver, String loginpageurl) throws Exception {
		Sheet sh = Utility.getSheet("Login");
		int rowcount = sh.getPhysicalNumberOfRows();

		for (int i = 1; i < rowcount; i++) {

			// login succeeds on this site and navigates to dashboard.html, so each row needs a fresh page load
			driver.get(loginpageurl);

			Row rr = sh.getRow(i);
			String usename = rr.getCell(0).getStringCellValue();
			String pwd = rr.getCell(1).getStringCellValue();

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
	}
}
