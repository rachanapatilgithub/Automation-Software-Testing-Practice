package com.automation.explicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_Explicit_ElementToBeClickable {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/dynamic-waits");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Scenario 5 : Submit button starts disabled, becomes enabled 3 seconds after arming
		driver.findElement(By.cssSelector("[data-testid='dw-arm-enable']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("dw-submit-btn"))).click();

		System.out.println(driver.findElement(By.cssSelector("[data-testid='result-s05']")).getText());

		driver.quit();
	}
}
