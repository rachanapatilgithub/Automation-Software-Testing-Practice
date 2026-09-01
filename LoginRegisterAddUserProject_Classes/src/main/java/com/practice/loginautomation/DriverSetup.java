package com.practice.loginautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

	public static WebDriver driver;

	public static void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://example.com/login");
	}

	public static void closeBrowser() {
		driver.quit();
	}
}
