package com.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormValidationCheck {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://practice.expandtesting.com/form-validation");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// Submit form without valid data
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(2000);

		// ===== Capture Validation Messages =====
		String nameError = driver.findElement(By.id("contactName-error")).getText();
		String phoneError = driver.findElement(By.id("contactNumber-error")).getText();
		String dateError = driver.findElement(By.id("pickupDate-error")).getText();
		String paymentError = driver.findElement(By.id("paymentMethod-error")).getText();

		// ===== Print Results =====
		System.out.println("Name Error: " + nameError);
		System.out.println("Phone Error: " + phoneError);
		System.out.println("Date Error: " + dateError);
		System.out.println("Payment Error: " + paymentError);

		// ===== Simple Validation Check =====
		if (!nameError.isEmpty() && !phoneError.isEmpty() && !dateError.isEmpty() && !paymentError.isEmpty()) {
			System.out.println("Validation messages displayed correctly");
		} else {
			System.out.println("Validation messages missing");
		}

		driver.quit();
	}
}
