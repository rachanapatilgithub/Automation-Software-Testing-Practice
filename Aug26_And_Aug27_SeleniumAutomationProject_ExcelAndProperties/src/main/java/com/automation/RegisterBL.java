package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterBL {

	WebDriver driver;

	public RegisterBL(WebDriver driver) {
		this.driver = driver;
	}

	public void register(String name, String mobile, String email, String password) {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(name);

		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile);

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div[1]/button")).click();

		System.out.println("Registration Executed");
	}
}
