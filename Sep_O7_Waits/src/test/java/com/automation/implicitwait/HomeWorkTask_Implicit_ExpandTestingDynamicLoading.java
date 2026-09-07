package com.automation.implicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Implicit_ExpandTestingDynamicLoading {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Example 2 : #finish is not in the DOM at all until loading finishes, so implicit
		// wait (which only waits for an element to be PRESENT, not visible) fits this page
		driver.get("https://practice.expandtesting.com/dynamic-loading/2");

		driver.findElement(By.cssSelector("#start button")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		String text = driver.findElement(By.id("finish")).getText();

		System.out.println(text);

		driver.quit();
	}
}
