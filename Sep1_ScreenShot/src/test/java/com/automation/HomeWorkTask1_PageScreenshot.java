package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// Task 1: take a screenshot of the whole page
public class HomeWorkTask1_PageScreenshot {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/index.html");

		ScreenshotUtil.takeScreenshot(driver, "HomeWorkTask1_PageScreenshot");

		driver.quit();
	}
}
