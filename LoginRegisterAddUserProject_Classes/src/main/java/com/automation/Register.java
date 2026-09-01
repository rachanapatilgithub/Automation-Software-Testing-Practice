package com.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Register {

	public static void register(WebDriver driver, String name, String mobile, String email, String password) {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(name);

		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile);

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div[1]/button")).click();

		// site shows a native "User registered successfully." alert on success -
		// accept it, otherwise the next command throws UnhandledAlertException
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert - " + alert.getText());
			alert.accept();
		} catch (NoAlertPresentException e) {
			// no alert this time (negative case with blank fields)
		}

		System.out.println("Registration Executed");
	}
}
