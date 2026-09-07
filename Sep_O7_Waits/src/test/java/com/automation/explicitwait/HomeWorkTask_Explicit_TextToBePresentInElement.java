package com.automation.explicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_Explicit_TextToBePresentInElement {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/dynamic-waits");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Scenario 1 : result-s01 text changes from "Element not visible" to
		// "Element appeared after 2s delay" once the delay finishes
		driver.findElement(By.cssSelector("[data-testid='dw-trigger-delayed']")).click();

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result-s01"), "appeared"));

		System.out.println(driver.findElement(By.id("result-s01")).getText());

		driver.quit();
	}
}
