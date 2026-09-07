package com.automation.implicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_ImplicitWaitTest {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/javascript-delays/");

		driver.findElement(By.id("start")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

		String text = driver.findElement(By.id("delay")).getText();

		System.out.println(text);

		driver.quit();
	}
}
