package com.automation.qaplaygroundiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Scenario4_NestedIframes {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/iframes");

		// outer frame - 1st level
		WebElement outerFrame = driver.findElement(By.cssSelector("[data-testid='iframe-outer']"));
		driver.switchTo().frame(outerFrame);

		// inner frame - 2nd level, nested inside the outer frame
		WebElement innerFrame = driver.findElement(By.cssSelector("iframe[title='Inner Frame']"));
		driver.switchTo().frame(innerFrame);

		driver.findElement(By.cssSelector("[data-testid='iframe-inner-input']")).sendKeys("kiran-secret");
		driver.findElement(By.cssSelector("[data-testid='iframe-inner-submit']")).click();

		// parentFrame() goes back one level - from inner frame to outer frame only
		driver.switchTo().parentFrame();

		// defaultContent() goes all the way back to the main page
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
