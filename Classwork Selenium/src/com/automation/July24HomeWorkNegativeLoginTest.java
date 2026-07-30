package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class July24HomeWorkNegativeLoginTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver(); // Open Browser
		System.out.println("Browser Open");

		Thread.sleep(2000);

		driver.manage().window().maximize(); // Maximize Window
		System.out.println("Window Maximized");

		Thread.sleep(2000);

		driver.get("https://javabykiran.com/liveproject/index.html"); // Open URL
		System.out.println("URL Open");

		Thread.sleep(2000);

		// Find Elements
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement sign = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));

		// ================= Test Case 1 =================

		System.out.println("Test Case 1 : Incorrect Username + Correct Password");

		username.sendKeys("abc@gmail.com");
		System.out.println("Email Entered");

		Thread.sleep(2000);

		password.sendKeys("123456");
		System.out.println("Password Entered");

		Thread.sleep(2000);

		sign.click();
		System.out.println("Login Button Clicked");

		Thread.sleep(2000);

		String title = driver.getTitle();

		if (title.equals("JavaByKiran | Dashboard")) {
			System.out.println("Test Case 1 Failed");
		} else {
			System.out.println("Test Case 1 Passed");
		}

		Thread.sleep(2000);

		// Clear Textboxes
		username.clear();
		password.clear();

		// ================= Test Case 2 =================

		System.out.println("Test Case 2 : Correct Username + Incorrect Password");

		username.sendKeys("kiran@gmail.com");
		System.out.println("Email Entered");

		Thread.sleep(2000);

		password.sendKeys("123");
		System.out.println("Password Entered");

		Thread.sleep(2000);

		sign.click();
		System.out.println("Login Button Clicked");

		Thread.sleep(2000);

		title = driver.getTitle();

		if (title.equals("JavaByKiran | Dashboard")) {
			System.out.println("Test Case 2 Failed");
		} else {
			System.out.println("Test Case 2 Passed");
		}

		Thread.sleep(2000);

		// Clear Textboxes
		username.clear();
		password.clear();

		// ================= Test Case 3 =================

		System.out.println("Test Case 3 : Username Blank + Password Blank");

		sign.click();
		System.out.println("Login Button Clicked");

		Thread.sleep(2000);

		title = driver.getTitle();

		if (title.equals("JavaByKiran | Dashboard")) {
			System.out.println("Test Case 3 Failed");
		} else {
			System.out.println("Test Case 3 Passed");
		}

		Thread.sleep(2000);

		driver.quit(); // Close Browser
		System.out.println("Browser Closed");
	}
}