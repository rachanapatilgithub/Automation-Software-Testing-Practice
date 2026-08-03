package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentRegistrationFormTest {
	public static void main(String[] args) throws InterruptedException {
//open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("browser open");
		// open url
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(2000);
		System.out.println("Form is open");

		// show lable
		WebElement name = driver.findElement(By.id("userName-label"));
		System.out.println(name.isDisplayed());
		System.out.println("name lable correctlt display");

		// enter name
		driver.findElement(By.id("firstName")).sendKeys("Rachana");
		Thread.sleep(1000);
		System.out.println("first name enter");
		// enter last name
		driver.findElement(By.id("lastName")).sendKeys("Patil");
		Thread.sleep(1000);
		System.out.println("last name enter");
		// show lable
		WebElement email = driver.findElement(By.id("userEmail-label"));
		System.out.println(email.isDisplayed());
		System.out.println("email lable correct display");

		// entter username
		driver.findElement(By.id("userEmail")).sendKeys("rachana@gmail.com");
		Thread.sleep(1000);
		System.out.println("eneter  usename");
		
		

	}
}
