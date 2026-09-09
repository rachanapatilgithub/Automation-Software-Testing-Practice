package com.automation.qaplaygroundiframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_Scenario5_DynamicContentWait {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/iframes");

		WebElement dynamicFrame = driver.findElement(By.cssSelector("[data-testid='iframe-dynamic']"));
		driver.switchTo().frame(dynamicFrame);

		// content only appears after a 1.5s delay - explicit wait instead of a fixed sleep
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement revealButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Reveal Secret']")));

		driver.findElement(By.id("dyn-code-input")).sendKeys("kiran123");
		revealButton.click();

		String result = driver.findElement(By.id("dyn-result")).getText();
		System.out.println("Scenario 5 result: " + result);

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
