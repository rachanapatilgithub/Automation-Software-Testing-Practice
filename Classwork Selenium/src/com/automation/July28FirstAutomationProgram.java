

/*
 * Task:
 * Create one fresh project.
 * Configure Selenium JAR files into that project.
 * Write the first automation program to open:
 * https://javabykiran.com/liveproject/index.html
 */





package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class July28FirstAutomationProgram {

	public static void main(String[] args) throws InterruptedException {

		// Open Chrome Browser
		WebDriver driver = new ChromeDriver();

		// Maximize Browser
		driver.manage().window().maximize();

		// Open Application
		driver.get("https://javabykiran.com/liveproject/index.html");

		// Wait for 3 seconds
		Thread.sleep(3000);

		// Print Page Title
		System.out.println("Title : " + driver.getTitle());

		// Close Browser
		driver.quit();
	}
}
