package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask1_RegiseterPageCssSelectorCopyFromBrower {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		System.out.println("Edge browser initialized.");
		
		driver.manage().window().maximize();
		System.out.println("Browser window maximized.");
		
		driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");
		System.out.println("Navigated to Register page.");
		
		driver.findElement(By.cssSelector("#name")).sendKeys("kiran Academy");
		System.out.println("Entered text into Name field.");
		
		driver.findElement(By.cssSelector("#mobile")).sendKeys("9876543210");
		System.out.println("Entered text into Mobile field.");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("kiran@academy.com");
		System.out.println("Entered text into Email field.");
		
		driver.findElement(By.cssSelector("#password")).sendKeys("SecurePass123");
		System.out.println("Entered text into Password field.");
		
		driver.findElement(By.cssSelector("#form > div.row > div > button")).click();
		System.out.println("Clicked on the Register button.");
		
		System.out.println("Test script execution completed.");
	}
}