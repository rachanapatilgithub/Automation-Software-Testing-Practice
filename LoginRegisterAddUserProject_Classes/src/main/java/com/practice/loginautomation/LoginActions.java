package com.practice.loginautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Reusable Methods - Contains only element actions, no test logic.
public class LoginActions {

	WebDriver driver;

	public LoginActions(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(By.id("loginBtn")).click();
	}

	public String getErrorMessage() {
		return driver.findElement(By.id("error")).getText();
	}

	public boolean isDashboardDisplayed() {
		return driver.findElement(By.id("dashboard")).isDisplayed();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
}
