package com.automation;

import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterTest {

	public static void main(String[] args) throws Exception {
		Properties pp = Utility.getProperties();
		String browsername = pp.getProperty("browser");
		String registerpageurl = pp.getProperty("registerurl");

		WebDriver driver = Utility.getDriver(browsername);

		register(driver, registerpageurl);

		driver.quit();
	}

	public static void register(WebDriver driver, String registerpageurl) throws Exception {
		Sheet sh = Utility.getSheet("Register");
		int rowcount = sh.getPhysicalNumberOfRows();
		DataFormatter df = new DataFormatter();

		for (int i = 1; i < rowcount; i++) {

			// registration succeeds on this site and redirects to index.html (login page), so reload before every row
			driver.get(registerpageurl);

			Row rr = sh.getRow(i);
			String name = df.formatCellValue(rr.getCell(0));
			String mobile = df.formatCellValue(rr.getCell(1));
			String email = df.formatCellValue(rr.getCell(2));
			String pwd = df.formatCellValue(rr.getCell(3));

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
	}
}
