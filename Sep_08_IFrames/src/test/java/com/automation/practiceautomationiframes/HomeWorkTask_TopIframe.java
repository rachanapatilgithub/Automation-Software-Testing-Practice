package com.automation.practiceautomationiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_TopIframe {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/iframes/");

		// top iframe embeds playwright.dev (id="iframe-1", name="top-iframe")
		WebElement topFrame = driver.findElement(By.id("iframe-1"));
		driver.switchTo().frame(topFrame);

		// getTitle() always returns the OUTER page's title, even inside a frame - so read
		// an element's text instead to prove we are really inside the iframe's document
		String heading = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Inside top iframe (Playwright), heading: " + heading);

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
