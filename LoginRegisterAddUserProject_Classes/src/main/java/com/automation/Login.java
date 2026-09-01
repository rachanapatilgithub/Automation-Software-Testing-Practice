package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	public static void login(WebDriver driver, String email, String password) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		// page has more than one button, so a plain "//button" is not unique
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button")).click();

		System.out.println("Login Executed");
	}
}
