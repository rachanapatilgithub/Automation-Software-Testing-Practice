package com.automation.explicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_Explicit_InvisibilityOfElementLocated {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-loading/1");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.cssSelector("#start button")).click();

		// wait until the "Loading..." indicator disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		String text = driver.findElement(By.id("finish")).getText();

		System.out.println(text);

		driver.quit();
	}
}
