package com.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// 1. Fill Form & Submit
public class FormFieldsAutomation {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://practice-automation.com/form-fields/");

		// ===== TEXT FIELDS =====
		driver.findElement(By.id("name")).sendKeys("John Doe");
		driver.findElement(By.id("password")).sendKeys("Test123");

		// ===== CHECKBOXES =====
		driver.findElement(By.id("drink1")).click(); // Water
		driver.findElement(By.id("drink3")).click(); // Coffee

		// ===== RADIO BUTTON =====
		driver.findElement(By.id("color2")).click(); // Blue

		// ===== DROPDOWN =====
		WebElement dropdown = driver.findElement(By.id("automation"));
		dropdown.click();
		driver.findElement(By.xpath("//option[text()='Yes']")).click();

		// ===== AUTOMATION TOOLS CHECKBOXES =====
		driver.findElement(By.id("selenium")).click();
		driver.findElement(By.id("playwright")).click();

		// ===== EMAIL =====
		driver.findElement(By.id("email")).sendKeys("john@test.com");

		// ===== MESSAGE =====
		driver.findElement(By.id("message")).sendKeys("This is a test message");

		// ===== SUBMIT =====
		driver.findElement(By.id("submit")).click();

		System.out.println("Form submitted successfully!");
		driver.quit();
	}
}
