package com.automation.qaplaygroundiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Scenario3_MultipleIframesByAttribute {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/iframes");

		// Frame 1 - located by data-testid
		WebElement frame1 = driver.findElement(By.cssSelector("[data-testid='iframe-frame-1']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.cssSelector("[data-testid='iframe-f1-action-btn']")).click();
		System.out.println("Frame 1: " + driver.findElement(By.id("f1-result")).getText());
		driver.switchTo().defaultContent();

		// Frame 2 - located by name (no testid on this one)
		WebElement frame2 = driver.findElement(By.cssSelector("iframe[name='frame-two']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.cssSelector("button[aria-label='Activate Frame Two']")).click();
		System.out.println("Frame 2: " + driver.findElement(By.id("f2-result")).getText());
		driver.switchTo().defaultContent();

		// Frame 3 - located by title (no testid, no name on this one)
		WebElement frame3 = driver.findElement(By.cssSelector("iframe[title='Frame Three']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//button[normalize-space()='Confirm Action']")).click();
		System.out.println("Frame 3: " + driver.findElement(By.id("f3-result")).getText());
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
