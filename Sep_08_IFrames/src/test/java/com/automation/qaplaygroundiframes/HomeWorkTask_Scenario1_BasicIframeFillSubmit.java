package com.automation.qaplaygroundiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Scenario1_BasicIframeFillSubmit {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/iframes");

		// switch by element located via data-testid
		WebElement basicFrame = driver.findElement(By.cssSelector("[data-testid='iframe-basic']"));
		driver.switchTo().frame(basicFrame);

		driver.findElement(By.cssSelector("[data-testid='iframe-name-input']")).sendKeys("Kiran Student");
		driver.findElement(By.cssSelector("[data-testid='iframe-submit-btn']")).click();

		String result = driver.findElement(By.id("result")).getText();
		System.out.println("Scenario 1 result: " + result);

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
