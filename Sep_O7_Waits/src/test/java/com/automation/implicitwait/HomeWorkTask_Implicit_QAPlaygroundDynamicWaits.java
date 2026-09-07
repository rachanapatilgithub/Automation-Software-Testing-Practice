package com.automation.implicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Implicit_QAPlaygroundDynamicWaits {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/dynamic-waits");

		// Scenario 7 : the fetch-result element does not exist in the DOM until the
		// network call finishes, so implicit wait (waits for PRESENCE) fits this scenario
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		driver.findElement(By.cssSelector("[data-testid='dw-fetch-btn']")).click();

		String text = driver.findElement(By.cssSelector("[data-testid='dw-fetch-result']")).getText();

		System.out.println(text);

		driver.quit();
	}
}
