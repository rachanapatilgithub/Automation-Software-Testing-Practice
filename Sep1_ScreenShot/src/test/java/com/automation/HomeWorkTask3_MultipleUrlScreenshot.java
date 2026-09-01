package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// Task 3: take a screenshot of multiple URLs, one by one
public class HomeWorkTask3_MultipleUrlScreenshot {

	public static void main(String[] args) throws Exception {

		String[] urls = {
				"https://javabykiran.com/liveproject/index.html",
				"https://javabykiran.com/liveproject/pages/examples/register.html",
				"https://javabykiran.com/liveproject/pages/examples/add_user.html"
		};

		String[] fileNames = {
				"HomeWorkTask3_LoginPageScreenshot",
				"HomeWorkTask3_RegisterPageScreenshot",
				"HomeWorkTask3_AddUserPageScreenshot"
		};

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		for (int i = 0; i < urls.length; i++) {
			driver.get(urls[i]);
			ScreenshotUtil.takeScreenshot(driver, fileNames[i]);
		}

		driver.quit();
	}
}
