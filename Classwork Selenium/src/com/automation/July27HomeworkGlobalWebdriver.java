package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class July27HomeworkGlobalWebdriver {
	




		// Global Declaration
		static WebDriver driver;

		// Open Browser
		public static void openBrowser() throws InterruptedException {

			driver = new ChromeDriver();
			System.out.println("Browser Open");

			Thread.sleep(2000);

			driver.manage().window().maximize();
			System.out.println("Window Maximized");

			Thread.sleep(2000);

			driver.get("https://javabykiran.com/liveproject/index.html");
			System.out.println("URL Open");

			Thread.sleep(2000);
		}

		// Positive Test Case
		public static void positiveTestCase() throws InterruptedException {

			System.out.println("Positive Test Case : Correct Username + Correct Password");

			WebElement username = driver.findElement(By.id("email"));
			username.sendKeys("kiran@gmail.com");
			System.out.println("Email Entered");

			Thread.sleep(2000);

			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("123456");
			System.out.println("Password Entered");

			Thread.sleep(2000);

			WebElement sign = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
			sign.click();
			System.out.println("Login Button Clicked");

			Thread.sleep(2000);

			String title = driver.getTitle();

			if (title.equals("JavaByKiran | Dashboard")) {
				System.out.println("Positive Test Case Passed");
			} else {
				System.out.println("Positive Test Case Failed");
			}
		}

		// Negative Test Cases
		public static void negativeTestCase() throws InterruptedException {

			driver.get("https://javabykiran.com/liveproject/index.html");
			Thread.sleep(2000);

			WebElement username = driver.findElement(By.id("email"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement sign = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));

			// Test Case 1
			System.out.println("Test Case 1 : Incorrect Username + Correct Password");

			username.sendKeys("abc@gmail.com");
			password.sendKeys("123456");
			sign.click();

			Thread.sleep(2000);

			if (driver.getTitle().equals("JavaByKiran | Dashboard")) {
				System.out.println("Test Case 1 Failed");
			} else {
				System.out.println("Test Case 1 Passed");
			}

			username.clear();
			password.clear();

			// Test Case 2
			System.out.println("Test Case 2 : Correct Username + Incorrect Password");

			username.sendKeys("kiran@gmail.com");
			password.sendKeys("123");
			sign.click();

			Thread.sleep(2000);

			if (driver.getTitle().equals("JavaByKiran | Dashboard")) {
				System.out.println("Test Case 2 Failed");
			} else {
				System.out.println("Test Case 2 Passed");
			}

			username.clear();
			password.clear();

			// Test Case 3
			System.out.println("Test Case 3 : Username Blank + Password Blank");

			sign.click();

			Thread.sleep(2000);

			if (driver.getTitle().equals("JavaByKiran | Dashboard")) {
				System.out.println("Test Case 3 Failed");
			} else {
				System.out.println("Test Case 3 Passed");
			}
		}

		// Main Method
		public static void main(String[] args) throws InterruptedException {

			openBrowser();

			positiveTestCase();

			negativeTestCase();

			driver.quit();
			System.out.println("Browser Closed");
		}
	}


