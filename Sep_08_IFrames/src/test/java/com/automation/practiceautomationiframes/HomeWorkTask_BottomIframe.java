package com.automation.practiceautomationiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_BottomIframe {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/iframes/");

		// bottom iframe embeds selenium.dev (id="iframe-2", name="bottom-iframe")
		WebElement bottomFrame = driver.findElement(By.id("iframe-2"));
		driver.switchTo().frame(bottomFrame);

		String heading = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Inside bottom iframe (Selenium), heading: " + heading);

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
