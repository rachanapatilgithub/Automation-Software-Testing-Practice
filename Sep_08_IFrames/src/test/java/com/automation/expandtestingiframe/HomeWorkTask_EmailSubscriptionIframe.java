package com.automation.expandtestingiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_EmailSubscriptionIframe {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/iframe");

		// internal iframe - loads a different page of the same site (iframe-email-subscribe)
		WebElement emailFrame = driver.findElement(By.id("email-subscribe"));
		driver.switchTo().frame(emailFrame);

		// fake email, just for practice - never use a real one here
		driver.findElement(By.id("email")).sendKeys("test.user@example.com");
		driver.findElement(By.id("btn-subscribe")).click();

		System.out.println("Submitted the email subscription form with fake data");

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
