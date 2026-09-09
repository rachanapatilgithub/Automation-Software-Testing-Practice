package com.automation.practiceautomationiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_AllInOne {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/iframes/");

		// ---------- Top iframe : playwright.dev ----------
		WebElement topFrame = driver.findElement(By.id("iframe-1"));
		driver.switchTo().frame(topFrame);
		System.out.println("Top iframe heading: " + driver.findElement(By.tagName("h1")).getText());
		driver.switchTo().defaultContent();

		// ---------- Bottom iframe : selenium.dev ----------
		WebElement bottomFrame = driver.findElement(By.id("iframe-2"));
		driver.switchTo().frame(bottomFrame);
		System.out.println("Bottom iframe heading: " + driver.findElement(By.tagName("h1")).getText());
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
