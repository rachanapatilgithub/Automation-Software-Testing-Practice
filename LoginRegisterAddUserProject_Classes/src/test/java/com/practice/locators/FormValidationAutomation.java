package com.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormValidationAutomation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://practice.expandtesting.com/form-validation");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// ===== Contact Name =====
		WebElement nameInput = driver.findElement(By.id("contactName"));
		nameInput.sendKeys("John Doe");

		// ===== Contact Number =====
		WebElement phoneInput = driver.findElement(By.id("contactNumber"));
		phoneInput.sendKeys("9876543210");

		// ===== Pickup Date =====
		WebElement dateInput = driver.findElement(By.id("pickupDate"));
		dateInput.sendKeys("12-12-2026");

		// ===== Payment Method =====
		WebElement paymentDropdown = driver.findElement(By.id("paymentMethod"));
		Select select = new Select(paymentDropdown);
		select.selectByVisibleText("Credit Card");

		// ===== Submit Form =====
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(2000);

		// ===== Validation Result =====
		String pageText = driver.getPageSource();
		if (pageText.contains("success") || pageText.contains("registered")) {
			System.out.println("Form submitted successfully");
		} else {
			System.out.println("Check validation messages on page");
		}

		driver.quit();
	}
}
