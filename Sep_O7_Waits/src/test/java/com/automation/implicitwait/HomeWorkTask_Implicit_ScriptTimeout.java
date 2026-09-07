package com.automation.implicitwait;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Implicit_ScriptTimeout {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// scriptTimeout is also part of driver.manage().timeouts(), used with executeAsyncScript
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

		driver.get("https://practice-automation.com/javascript-delays/");

		System.out.println("Script timeout set to 10 seconds");

		driver.quit();
	}
}
