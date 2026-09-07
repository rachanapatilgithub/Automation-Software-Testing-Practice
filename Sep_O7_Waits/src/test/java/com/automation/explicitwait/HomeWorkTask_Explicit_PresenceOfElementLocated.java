package com.automation.explicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_Explicit_PresenceOfElementLocated {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-loading/2");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.cssSelector("#start button")).click();

		// #finish does not exist in the DOM at all until loading finishes, so we need
		// presenceOfElementLocated (not just visibility) here
		WebElement finish = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

		System.out.println(finish.getText());

		driver.quit();
	}
}
