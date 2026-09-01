package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

// Task 2: take a screenshot of just one element (not the whole page)
public class HomeWorkTask2_ElementScreenshot {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/index.html");

		WebElement signInButton = driver.findElement(By.cssSelector("button.btn-flat"));

		ScreenshotUtil.takeElementScreenshot(signInButton, "HomeWorkTask2_ElementScreenshot");

		driver.quit();
	}
}
