package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBL {

	WebDriver driver;

	public LoginBL(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String email, String password) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button")).click();

		System.out.println("Login Executed");
	}
}
