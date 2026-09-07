package com.automation.implicitwait;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Implicit_PageLoadTimeout {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// pageLoadTimeout is also part of driver.manage().timeouts(), same family as implicitlyWait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

		try {
			driver.get("https://practice-automation.com/javascript-delays/");
			System.out.println("Page loaded within 15 seconds");
		} catch (TimeoutException e) {
			System.out.println("Page did not load within 15 seconds");
		}

		driver.quit();
	}
}
